package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Item;

import java.util.List;
import java.util.Optional;

public interface CostRepository {
    Item addCost(String product, double price, Category category);

    Optional<Item> updateCost(String oldProduct, String newProduct, double newPrice);

    Optional<Item> getCost(String product);

    Optional<Item> deleteCost(String product);

    List<Item> getAll();
}