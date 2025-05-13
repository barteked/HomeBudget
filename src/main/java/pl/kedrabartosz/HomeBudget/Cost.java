package pl.kedrabartosz.HomeBudget;

public interface Cost {

    public double getPrice();

    public Category getCategory();

    public void setProduct(String product);

    public String getProduct();

    public void setPrice(double price);
}