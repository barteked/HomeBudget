package pl.kedrabartosz.HomeBudget;

public class SimpleCost implements Cost {
    private String description;
    private double amount;

    public SimpleCost(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return description + ": " + amount + " zł";
    }

    @Override
    public double getPrice() {
        return amount;
    }

    @Override
    public Category getCategory() {
        return null;
    }
}