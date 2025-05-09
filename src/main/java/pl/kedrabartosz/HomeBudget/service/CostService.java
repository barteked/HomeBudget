package pl.kedrabartosz.HomeBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.repository.CostRepository;

@Service
public class CostService {

  private CostRepository listBasedRepository;

  public CostService(@Autowired  CostRepository listBasedRepository) {
    // = to przypisanie = to jest włąśnie wstrzykiwanie zależności
    this.listBasedRepository = listBasedRepository;
  }

  public Cost saveCost(String name, double price){
    return listBasedRepository.addCost(name, price);
  }
}
