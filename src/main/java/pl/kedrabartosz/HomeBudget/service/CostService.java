package pl.kedrabartosz.HomeBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;

import java.util.List;

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
        return listBasedRepository.updateCost(oldProduct, newProduct, newPrice);
    }

    public Cost getCost(String product) {
        return listBasedRepository.getCost(product);
    }

    public Cost deleteCost(String product) {
        return listBasedRepository.deleteCost(product);
    }

    public List<Cost> getAllCosts() {
        return listBasedRepository.getAll();
    }
}
