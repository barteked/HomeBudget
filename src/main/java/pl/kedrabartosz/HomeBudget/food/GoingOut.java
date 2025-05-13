package pl.kedrabartosz.HomeBudget.food;

import pl.kedrabartosz.HomeBudget.Category;

public class GoingOut implements Food{
    @Override
    public void food() {

    }
    @Override
    public double getPrice() {
        return 0;
    }

    public GoingOut() {
        super();
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
