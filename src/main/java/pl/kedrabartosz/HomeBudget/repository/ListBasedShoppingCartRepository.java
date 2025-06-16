package pl.kedrabartosz.HomeBudget.repository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@NoArgsConstructor
public class ListBasedShoppingCartRepository implements ShoppingCartRepository {
    private final List<ShoppingCart> store = new ArrayList<>();

    @Override
    public ShoppingCart save(ShoppingCart cart) {
        store.add(cart);
        return cart;
    }

    @Override
    public List<ShoppingCart> findAllByPerson(Person person) {
        return store.stream()
                .filter(c -> c.getPerson().equals(person))
                .collect(Collectors.toList());
    }
}