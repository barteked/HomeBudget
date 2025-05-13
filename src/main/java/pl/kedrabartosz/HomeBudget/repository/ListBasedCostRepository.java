package pl.kedrabartosz.HomeBudget.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.SimpleCost;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Builder
public class ListBasedCostRepository implements CostRepository {
    private List<Cost> costs;

    @Override
    public Cost addCost(String product, double price, Category category) {
        Cost exampleCost = new SimpleCost(product, price, category);
        costs.add(exampleCost);
        return exampleCost;
    }

    @Override
    public Cost updateCost(String oldProduct, String newProduct, double newPrice) {
        Cost costToUpdate = getCost(oldProduct);
        costToUpdate.setProduct(newProduct);
        costToUpdate.setPrice(newPrice);
        return costToUpdate;
    }

    @Override
    public Cost getCost(String product) {
        return costs.stream()
                .filter(cost -> cost.getProduct().equalsIgnoreCase(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find Cost with this product: " + product));
    }

    @Override
    public Cost deleteCost(String product) {
        Cost costToDelete = getCost(product);
        costs.remove(costToDelete);
        return costToDelete;
    }

    @Override
    public List<Cost> getAll() {
        return new ArrayList<>(costs);
    }
}
