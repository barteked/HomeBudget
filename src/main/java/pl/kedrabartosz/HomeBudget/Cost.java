package pl.kedrabartosz.HomeBudget;

import pl.kedrabartosz.HomeBudget.repository.CostRepository;

public interface Cost {

    public double getPrice();

    public Category getCategory();
}
