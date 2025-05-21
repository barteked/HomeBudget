package pl.kedrabartosz.HomeBudget.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.SimpleCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<Cost> updateCost(String oldProduct, String newProduct, double newPrice) {
        Optional<Cost> existingCostOptional = this.getCost(oldProduct);
        existingCostOptional.ifPresent(cost -> cost.setPrice(newPrice));
        return existingCostOptional;
    }

    @Override
    public Optional<Cost> getCost(String product) {
        return costs.stream()
                .filter(cost -> cost.getProduct().equalsIgnoreCase(product))
                .findFirst();
    }

    @Override
    public Optional<Cost> deleteCost(String product) {
        Optional<Cost> toRemoveOptional = getCost(product);
        if (toRemoveOptional.isEmpty()) {
            return Optional.empty();
        }
        Cost toRemoveCost = toRemoveOptional.get();
        costs.remove(toRemoveCost);
        return Optional.of(toRemoveCost);
    }

    @Override
    public List<Cost> getAll() {
        return new ArrayList<>(costs);
    }

}
