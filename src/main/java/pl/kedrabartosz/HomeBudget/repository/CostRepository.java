package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Cost;

import java.util.List;

public interface CostRepository {
    Cost addCost(String product, double price);

    public Cost updateCost();

    public Cost getCost();

    public Cost deleteCost();

    public List<Cost> getAll();
}
