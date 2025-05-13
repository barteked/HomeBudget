package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;

import java.util.List;

public interface CostRepository {
    Cost addCost(String product, double price, Category category);

    public Cost updateCost(String oldProduct, String newProduct, double newPrice);

    public Cost getCost(String product);

    public Cost deleteCost(String product);

    public List<Cost> getAll();
}
