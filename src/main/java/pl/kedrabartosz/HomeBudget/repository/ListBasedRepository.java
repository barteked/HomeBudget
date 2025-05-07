package pl.kedrabartosz.HomeBudget.repository;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.SimpleCost;

import java.util.ArrayList;
import java.util.List;

public class ListBasedRepository implements CostRepository {
    private List<Cost> costs = new ArrayList<>();

    @Override
    public Cost addCost() {
        Cost exampleCost = new SimpleCost("Pizza",25.0);
        costs.add(exampleCost);
        return exampleCost;
    }

    @Override
    public Cost updateCost() {
        return null;
    }

    @Override
    public Cost getCost() {
        return null;
    }

    @Override
    public Cost deleteCost() {
        return null;
    }

    @Override
    public List<Cost> getAll() {
        return new ArrayList<>(costs);
    }
}
