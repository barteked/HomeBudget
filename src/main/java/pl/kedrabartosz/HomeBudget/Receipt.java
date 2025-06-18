package pl.kedrabartosz.HomeBudget;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@ToString
@Getter
public class Receipt {

    private Person person;
    private List<Item> items;
    private BigDecimal priceOfItems;
    private Instant time;

    public Receipt(Person person, List<Item> items, Instant time) {
        this.person = person;
        this.items = items;
        this.priceOfItems = getFullPrice();
        this.time = time;
    }

    private BigDecimal getFullPrice() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(BigDecimal.valueOf(item.getPrice()));
        }
        return sum;
    }

}
