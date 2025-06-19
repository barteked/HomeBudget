package pl.kedrabartosz.HomeBudget.repository;

import java.util.ArrayList;

public class ItemRepositoryFactory {

    private ItemRepositoryFactory() {
    }

    public static ItemRepository createCostRepository() {
        return new ListBasedItemRepository(new ArrayList<>());
    }
}
