package pl.kedrabartosz.HomeBudget.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Item;

import java.util.ArrayList;

class ListBasedItemRepositoryTest {

    private ListBasedItemRepository listBasedCostRepository = new ListBasedItemRepository(new ArrayList<>());

    @Test
    public void shouldAddNewCost() {
        //Given to co daje przygotowuje dane
        String product = "product";
        double price = 22;
        Category category = Category.builder().build();
        //When co testujemy 1 max 2 linijki!!
        Item actual = listBasedCostRepository.addItem(product, price, category);

        //Then sprawdzam wynik z when!
        Assertions.assertEquals(product, actual.getProduct());
        Assertions.assertEquals(price, actual.getPrice());
        Assertions.assertEquals(category, actual.getCategory());
    }

}