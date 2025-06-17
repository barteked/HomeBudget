package pl.kedrabartosz.HomeBudget;

public class SimpleCost implements Cost {
    private String product;
    private double price;
    private Category category;
    private Person person;

    public SimpleCost(String product,
                      double price,
                      Category category,
                      Person person) {
        this.product  = product;
        this.price    = price;
        this.category = category;
        this.person   = person;
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
    public Person getPerson() {
        return person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return product +
                ": " + price + " zł, " +
                "category=" + category.getName() +
                ", person=" + person.getName();
    }
}