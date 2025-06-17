package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Person;

import java.util.List;
import java.util.Optional;

public interface CostRepository {
    Cost addCost(String product, double price, Category category, String name);

    Optional<Cost> updateCost(String oldProduct, String newProduct, double newPrice);

    Optional<Cost> getCost(String product);

    Optional<Cost> deleteCost(String product);

    List<Cost> getAll();
}