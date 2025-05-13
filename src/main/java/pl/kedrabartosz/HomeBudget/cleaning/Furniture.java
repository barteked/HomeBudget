package pl.kedrabartosz.HomeBudget.cleaning;

import pl.kedrabartosz.HomeBudget.Category;

public class Furniture implements Cleaning{
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

    public Furniture() {
        super();
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public String getProduct() {
        return "";
    }

    @Override
    public void setProduct(String product) {

    }
}
