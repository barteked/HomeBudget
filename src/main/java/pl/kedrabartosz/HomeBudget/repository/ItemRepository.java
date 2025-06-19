package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item addItem(String product, double price, Category category);

    Optional<Item> updateItem(String oldProduct, String newProduct, double newPrice);

    Optional<Item> getItemByName(String itemName);

    Optional<Item> deleteItem(String product);

    List<Item> getAll();
}