package pl.kedrabartosz.HomeBudget.entertainment;

import pl.kedrabartosz.HomeBudget.Category;

public class Cinema implements Entertainment{
    @Override
    public void entertain() {

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
