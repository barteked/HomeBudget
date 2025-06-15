package pl.kedrabartosz.HomeBudget.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.ShoppingCart;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListBasedShoppingCartService implements ShoppingCartService {

    private final CategoryRepository categoryRepository;
    private final CostRepository costRepository;

    @Override
    public Cost addExpense(Person person, String product, double price, String categoryName) {
        Category category = categoryRepository
                .getCategory(categoryName)
                .orElseGet(() -> categoryRepository.save(categoryName));

        return costRepository.addCost(product, price, category);
    }

    @Override
    public Optional<Cost> updateExpense(Person person,
                                        String oldProduct,
                                        String newProduct,
                                        double newPrice) {

        return costRepository.updateCost(oldProduct, newProduct, newPrice);
    }

    @Override
    public Optional<Cost> removeExpense(Person person, String product) {
        return costRepository.deleteCost(product);
    }

    @Override
    public ShoppingCart getCart(Person person) {
        List<Cost> items = costRepository.getAll();
        BigDecimal total = items.stream()
                .map(c -> BigDecimal.valueOf(c.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new ShoppingCart(person, items, total, Instant.now());
    }
}