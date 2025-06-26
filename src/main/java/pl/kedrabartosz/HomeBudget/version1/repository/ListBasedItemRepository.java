package pl.kedrabartosz.HomeBudget.version1.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.version1.Category;
import pl.kedrabartosz.HomeBudget.version1.Item;
import pl.kedrabartosz.HomeBudget.version1.SimpleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Builder
public class ListBasedItemRepository implements ItemRepository {
    private List<Item> items;

    @Override
    public Item addItem(String product, double price, Category category) {
        Item item = new SimpleItem(product, price, category);
        items.add(item);
        return item;
    }


    @Override
    public Optional<Item> updateItem(String oldProduct, String newProduct, double newPrice) {
        Optional<Item> existingCostOptional = this.getItemByName(oldProduct);
        existingCostOptional.ifPresent(item -> item.setPrice(newPrice));
        return existingCostOptional;
    }

    @Override
    public Optional<Item> getItemByName(String itemName) {
        return items.stream()
                .filter(item -> item.getProduct().equalsIgnoreCase(itemName))
                .findFirst();
    }

    @Override
    public Optional<Item> deleteItem(String product) {
        Optional<Item> toRemoveOptional = getItemByName(product);
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
