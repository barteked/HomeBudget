package pl.kedrabartosz.HomeBudget;

public class SimpleCost implements Cost {
    private String product;
    private double price;
    private Category category;

    public SimpleCost(String product, double price, Category category) {
        this.product = product;
        this.price = price;
        this.category = category;
    }

    // Getter i setter dla product!!!!!
    @Override
    public String getProduct() {
        return product;
    }

    @Override
    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public String toString() {
        return product + ": " + price + " zł, Category: " + category.getName();
    }
}
