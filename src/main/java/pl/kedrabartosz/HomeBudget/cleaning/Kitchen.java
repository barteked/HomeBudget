package pl.kedrabartosz.HomeBudget.cleaning;

import pl.kedrabartosz.HomeBudget.Category;

public class Kitchen implements Cleaning{
    @Override
    public void clean() {

    }
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public Category getCategory() {
        return null;
    }
}
