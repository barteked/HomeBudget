package pl.kedrabartosz.HomeBudget.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;

@Service
public class CostService {

    private CostRepository listBasedRepository;

    public CostService(@Autowired CostRepository listBasedRepository) {
        // = to przypisanie = to jest włąśnie wstrzykiwanie zależności
        this.listBasedRepository = listBasedRepository;
    }

    public Cost saveCost(String name, double price, Category category) {
        return listBasedRepository.addCost(name, price, category);
    }

    public Cost updateCost(String oldProduct, String newProduct, double newPrice) {
        Optional<Cost> updateCostOptional = listBasedRepository.updateCost(oldProduct, newProduct, newPrice);
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
        Optional<Cost> costOptional = listBasedRepository.getCost(product);
        if (costOptional.isEmpty()) {
            System.out.println("Could not get Cost with product" + product);
            throw new IllegalArgumentException("Could not get Cost");
        }
        return costOptional.get();
    }

    public Cost deleteCost(String product) {
        Optional<Cost> deletedCostOptional = listBasedRepository.deleteCost(product);
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
