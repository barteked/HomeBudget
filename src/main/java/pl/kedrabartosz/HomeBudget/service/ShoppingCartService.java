package pl.kedrabartosz.HomeBudget.service;

import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {


    Cost addItemToCart(Person person, String product, double price, String categoryName);

    Optional<ShoppingCart> updateCart(Person person, String oldProduct, String newProduct, double newPrice);




    Optional<Cost> removeItemFromCart(Person person, String product);

    List<ShoppingCart> getShoppingCarts(Person person);
    ShoppingCart getShoppingCart(Person person);
    ShoppingCart checkout(Person person);

}