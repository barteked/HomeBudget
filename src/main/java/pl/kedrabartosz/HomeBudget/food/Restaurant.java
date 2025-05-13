package pl.kedrabartosz.HomeBudget.food;

import pl.kedrabartosz.HomeBudget.Category;

public class Restaurant implements Food{
    @Override
    public void food() {

    }
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public Category getCategory() {
        return null;
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
