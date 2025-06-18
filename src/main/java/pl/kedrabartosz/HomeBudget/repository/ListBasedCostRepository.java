package pl.kedrabartosz.HomeBudget.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Item;
import pl.kedrabartosz.HomeBudget.SimpleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Builder
public class ListBasedCostRepository implements CostRepository {
    private List<Item> items;

    @Override
    public Item addCost(String product, double price, Category category) {
        Item item = new SimpleItem(product, price, category);
        items.add(item);
        return item;
    }


    @Override
    public Optional<Item> updateCost(String oldProduct, String newProduct, double newPrice) {
        Optional<Item> existingCostOptional = this.getCost(oldProduct);
        existingCostOptional.ifPresent(cost -> cost.setPrice(newPrice));
        return existingCostOptional;
    }

    @Override
    public Optional<Item> getCost(String product) {
        return items.stream()
                .filter(cost -> cost.getProduct().equalsIgnoreCase(product))
                .findFirst();
    }

    @Override
    public Optional<Item> deleteCost(String product) {
        Optional<Item> toRemoveOptional = getCost(product);
        if (toRemoveOptional.isEmpty()) {
            return Optional.empty();
        }
        Item toRemoveItem = toRemoveOptional.get();
        items.remove(toRemoveItem);
        return Optional.of(toRemoveItem);
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(items);
    }

}
