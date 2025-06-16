package pl.kedrabartosz.HomeBudget;

public interface Cost {

    String getProduct();
    void setProduct(String product);

    double getPrice();
    void setPrice(double price);

    Category getCategory();
    void setCategory(Category category);

    Person getPerson();
    void setPerson(Person person);
}