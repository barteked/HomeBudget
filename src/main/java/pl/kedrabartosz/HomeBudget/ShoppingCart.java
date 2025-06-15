package pl.kedrabartosz.HomeBudget;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
@Getter
public class ShoppingCart {
    private Person person;
    private List<Cost> items;
    private BigDecimal priceOfItems;
    private Instant time;

    public ShoppingCart(Person person, List<Cost> items, BigDecimal priceOfItems, Instant time) {
        this.person = person;
        this.items = items;
        this.priceOfItems = priceOfItems;
        this.time = time;
    }
}
