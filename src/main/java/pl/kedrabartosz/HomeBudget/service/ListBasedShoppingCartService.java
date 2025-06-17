package pl.kedrabartosz.HomeBudget.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.ShoppingCart;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;
import pl.kedrabartosz.HomeBudget.repository.ShoppingCartRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListBasedShoppingCartService implements ShoppingCartService {

    private final CategoryRepository categoryRepository;
    private final CostRepository costRepository;
    private final ShoppingCartRepository cartRepository;

    @Override
    public Cost addItemToCart(Person person, String product, double price, String categoryName) {
        Category category = categoryRepository
                .getCategory(categoryName)
                .orElseGet(() -> categoryRepository.save(categoryName));
        return costRepository.addCost(person, product, price, category);
    }

    @Override
    public Optional<ShoppingCart> updateCart(Person person,
                                             String oldProduct,
                                             String newProduct,
                                             double newPrice) {
        Optional<Cost> updated = costRepository.updateCost(oldProduct, newProduct, newPrice);
        if (updated.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(checkout(person));
    }

    @Override
    public Optional<Cost> removeItemFromCart(Person person, String product) {
        return costRepository.deleteCost(product);
    }

    @Override
    public ShoppingCart checkout(Person person) {
        List<Cost> items = costRepository.getAll().stream()// getall out!
                .filter(c -> c.getPerson().equals(person))
                .collect(Collectors.toList());
       /* BigDecimal total = items.stream()
                .map(c -> BigDecimal.valueOf(c.getPrice()))
                .reduce(BigDecimal.ZERO, (elementOne, elementTwo) -> elementOne.add(elementTwo)); */
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < items.size(); i++) {
            Cost cost = items.get(i);
            BigDecimal priceBigDecimal = BigDecimal.valueOf(cost.getPrice());
            total = total.add(priceBigDecimal);
        }
        ShoppingCart cart = new ShoppingCart(person, items, total, Instant.now());
        return cartRepository.save(cart);
    }

    @Override
    public ShoppingCart getShoppingCart(Person person) {
        return cartRepository.findAllByPerson(person).stream()
                .reduce((first, second) -> second)
                .orElseThrow(() ->
                        new IllegalStateException("No session for " + person.getName()));
    }

    @Override
    public List<ShoppingCart> getShoppingCarts(Person person) {
        return cartRepository.findAllByPerson(person);
    }
}