package pl.kedrabartosz.HomeBudget.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Item;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;

@Service
public class CostService {

    private CostRepository listBasedRepository;

    public CostService(@Autowired CostRepository listBasedRepository) {
        // = to przypisanie = to jest włąśnie wstrzykiwanie zależności
        this.listBasedRepository = listBasedRepository;
    }

    public Item saveCost(String name, double price, Category category) {
        return listBasedRepository.addCost(name, price, category);
    }

    public Item updateCost(String oldProduct, String newProduct, double newPrice) {
        Optional<Item> updateCostOptional = listBasedRepository.updateCost(oldProduct, newProduct, newPrice);
        if (updateCostOptional.isEmpty()) {
            System.out.println("Could not update cost with oldProduct" + oldProduct);
            throw new IllegalArgumentException("Could not update cost");
        }
        return updateCostOptional.get();
    }

    public boolean doesCostExist(String product) {
        Optional<Item> costOptional = listBasedRepository.getCost(product);
        if (costOptional.isPresent()) {
            return true;
        }
        return false;
    }

    public Item getCost(String product) {
        Optional<Item> costOptional = listBasedRepository.getCost(product);
        if (costOptional.isEmpty()) {
            System.out.println("Could not get Cost with product" + product);
            throw new IllegalArgumentException("Could not get Cost");
        }
        return costOptional.get();
    }

    public Item deleteCost(String product) {
        Optional<Item> deletedCostOptional = listBasedRepository.deleteCost(product);
        if (deletedCostOptional.isEmpty()) {
            System.out.println("Could not delete cost with product" + product);
            throw new IllegalArgumentException("Could not delete cost");
        }
        return deletedCostOptional.get();
    }

    public List<Item> getAllCosts() {
        return listBasedRepository.getAll();
    }
}
