package pl.kedrabartosz.HomeBudget.version1;

public interface Item {

    String getProduct();

    void setProduct(String product);

    double getPrice();

    void setPrice(double price);

    Category getCategory();

    void setCategory(Category category);


}