package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;

import java.util.List;
import java.util.Optional;

public interface CostRepository {
    Cost addCost(String product, double price, Category category);

    public Optional<Cost> updateCost(String oldProduct, String newProduct, double newPrice);

    public Optional<Cost> getCost(String product);

    public Optional<Cost> deleteCost(String product);

    public List<Cost> getAll();
}
