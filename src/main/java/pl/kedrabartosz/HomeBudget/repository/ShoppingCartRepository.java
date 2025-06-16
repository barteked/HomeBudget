package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.ShoppingCart;

import java.util.List;

public interface ShoppingCartRepository {
    ShoppingCart save(ShoppingCart cart);
    List<ShoppingCart> findAllByPerson(Person person);
}
