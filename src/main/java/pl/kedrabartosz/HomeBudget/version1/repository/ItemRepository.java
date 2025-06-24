package pl.kedrabartosz.HomeBudget.version1.repository;

import pl.kedrabartosz.HomeBudget.version1.Category;
import pl.kedrabartosz.HomeBudget.version1.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item addItem(String product, double price, Category category);

    Optional<Item> updateItem(String oldProduct, String newProduct, double newPrice);

    Optional<Item> getItemByName(String itemName);

    Optional<Item> deleteItem(String product);

    List<Item> getAll();
}