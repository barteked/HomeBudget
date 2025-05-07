package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Cost;

import java.util.List;

public interface CostRepository {
    public Cost addCost();

    public Cost updateCost();

    public Cost getCost();

    public Cost deleteCost();

    public List<Cost> getAll();
}
