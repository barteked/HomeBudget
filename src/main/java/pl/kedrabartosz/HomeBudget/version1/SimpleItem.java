package pl.kedrabartosz.HomeBudget.version1;

public class SimpleItem implements Item {
    private String product;
    private double price;
    private Category category;

    public SimpleItem(String product,
                      double price,
                      Category category
    ) {
        this.product = product;
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
        return product +
                ": " + price + " zł, " +
                "category=" + category.getName();

    }
}