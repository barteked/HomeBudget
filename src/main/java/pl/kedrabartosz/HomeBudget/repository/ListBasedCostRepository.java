package pl.kedrabartosz.HomeBudget.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.SimpleCost;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Builder
public class ListBasedCostRepository implements CostRepository {
    private List<Cost> costs = new ArrayList<>();

    @Override
    public Cost addCost(String product, double price) {
        Cost exampleCost = new SimpleCost(product, price);
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
