package pl.kedrabartosz.HomeBudget.development;

import pl.kedrabartosz.HomeBudget.Category;

public class Courses implements Development{
    @Override
    public void develop() {

    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public Category getCategory() {
        return null;
    }

    public Courses() {
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
