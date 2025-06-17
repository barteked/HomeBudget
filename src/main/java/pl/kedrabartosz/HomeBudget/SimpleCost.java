package pl.kedrabartosz.HomeBudget;

public class SimpleCost implements Cost {
    private String product;
    private String name;
    private double price;
    private Category category;

    public SimpleCost(String product, String name, double price, Category category) {
        this.product = product;
      this.name = name;
      this.price = price;
        this.category = category;
    }

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
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return product + ": " + price + " zł, Category: " + category.getName() ;
    }
}