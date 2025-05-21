package pl.kedrabartosz.HomeBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;
import pl.kedrabartosz.HomeBudget.repository.ListBasedCostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CostService {

    private final ListBasedCostRepository listBasedCostRepository;
    private CostRepository listBasedRepository;

    public CostService(@Autowired CostRepository listBasedRepository, ListBasedCostRepository listBasedCostRepository) {
        // = to przypisanie = to jest włąśnie wstrzykiwanie zależności
        this.listBasedRepository = listBasedRepository;
        this.listBasedCostRepository = listBasedCostRepository;
    }

    public Cost saveCost(String name, double price, Category category) {
        return listBasedRepository.addCost(name, price, category);
    }

    public Cost updateCost(String oldProduct, String newProduct, double newPrice) {
        Optional<Cost> updateCostOptional = listBasedCostRepository.updateCost(oldProduct, newProduct, newPrice);
        if (updateCostOptional.isEmpty()) {
            System.out.println("Could not update cost with oldProduct" + oldProduct);
            throw new IllegalArgumentException("Colud not update cost");
        }
        return updateCostOptional.get();
    }

    public boolean doesCostExist(String product) {
        Optional<Cost> costOptional = listBasedRepository.getCost(product);
        if (costOptional.isPresent()) {
            return true;
        }
        return false;
    }

    public Cost getCost(String product) {
        Optional<Cost> costOptional = listBasedCostRepository.getCost(product);
        if (costOptional.isEmpty()) {
            System.out.println("Could not get Cost with product" + product);
            throw new IllegalArgumentException("Could not get Cost");
        }
        return costOptional.get();
    }

    public Cost deleteCost(String product) {
        Optional<Cost> deletedCostOptional = listBasedCostRepository.deleteCost(product);
        if (deletedCostOptional.isEmpty()) {
            System.out.println("Could not delete cost with product" + product);
            throw new IllegalArgumentException("Could not delete cost");
        }
        return deletedCostOptional.get();
    }

    public List<Cost> getAllCosts() {
        return listBasedRepository.getAll();
    }
}
