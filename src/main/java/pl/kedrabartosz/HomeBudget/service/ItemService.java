package pl.kedrabartosz.HomeBudget.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Item;
import pl.kedrabartosz.HomeBudget.repository.ItemRepository;

@Service
public class ItemService {

    private ItemRepository listBasedRepository;

    public ItemService(@Autowired ItemRepository listBasedRepository) {
        // = to przypisanie = to jest włąśnie wstrzykiwanie zależności
        this.listBasedRepository = listBasedRepository;
    }

    public Item saveItem(String name, double price, Category category) {
        return listBasedRepository.addItem(name, price, category);
    }

    public Item updateItem(String oldProduct, String newProduct, double newPrice) {
        Optional<Item> updateItemOptional = listBasedRepository.updateItem(oldProduct, newProduct, newPrice);
        if (updateItemOptional.isEmpty()) {
            System.out.println("Could not update cost with oldProduct" + oldProduct);
            throw new IllegalArgumentException("Could not update cost");
        }
        return updateItemOptional.get();
    }

    public boolean doesItemExits(String product) {
        Optional<Item> itemOptional = listBasedRepository.getItem(product);
        if (itemOptional.isPresent()) {
            return true;
        }
        return false;
    }

    public Item getItem(String product) {
        Optional<Item> itemOptional = listBasedRepository.getItem(product);
        if (itemOptional.isEmpty()) {
            System.out.println("Could not get Cost with product" + product);
            throw new IllegalArgumentException("Could not get Cost");
        }
        return itemOptional.get();
    }

    public Item deleteItem(String product) {
        Optional<Item> deletedItemOptional = listBasedRepository.deleteItem(product);
        if (deletedItemOptional.isEmpty()) {
            System.out.println("Could not delete cost with product" + product);
            throw new IllegalArgumentException("Could not delete cost");
        }
        return deletedItemOptional.get();
    }

    public List<Item> getAllItems() {
        return listBasedRepository.getAll();
    }
}
