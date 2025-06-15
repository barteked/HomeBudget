package pl.kedrabartosz.HomeBudget.service;

import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.ShoppingCart;

import java.util.Optional;

public interface ShoppingCartService {

    Cost addExpense(Person person, String product, double price, String categoryName);

    Optional<Cost> updateExpense(Person person,
                                 String oldProduct,
                                 String newProduct,
                                 double newPrice);

    Optional<Cost> removeExpense(Person person, String product);

    ShoppingCart getCart(Person person);
}