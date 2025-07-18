package pl.kedrabartosz.HomeBudget.version2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kedrabartosz.HomeBudget.version2.entities.CategoryEntity;
import pl.kedrabartosz.HomeBudget.version2.entities.ItemEntity;
import pl.kedrabartosz.HomeBudget.version2.entities.QuantityEntity;
import pl.kedrabartosz.HomeBudget.version2.repositories.ItemRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemServiceTest {
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private QuantityService quantityService;

    @Mock
    private CategoryEntity category;

    @Mock
    private QuantityEntity quantityEntity;

    private ItemEntity itemEntity;

    private static final int EXISTING_ITEM_ID = 1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        itemService = new ItemService(itemRepository, quantityService);
        quantityEntity = QuantityEntity.builder().id(1).value("kg").build();
        category = CategoryEntity.builder().name("Food").build();
        itemEntity = ItemEntity.builder()
                .name("TestItem")
                .quantityEntity(quantityEntity)
                .categoryEntity(category)
                .build();
    }

    @Test
    void shouldSaveItem() {

        when(quantityService.doesQuantityExist(EXISTING_ITEM_ID)).thenReturn(true);
        when(quantityService.getQuantity(EXISTING_ITEM_ID)).thenReturn(quantityEntity);
        when(itemRepository.save(eq(itemEntity))).thenReturn(itemEntity);

        var result = itemService.saveItem("TestItem", EXISTING_ITEM_ID, category);

        assertEquals(itemEntity, result);
    }

    @Test
    void shouldThrowExceptionWhenSavingItemFails() {
        when(quantityService.getQuantity(EXISTING_ITEM_ID)).thenThrow(new IllegalArgumentException());
        when(itemRepository.save(any(ItemEntity.class))).thenReturn(itemEntity);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.saveItem("TestItem", 1, category));

        verify(itemRepository, times(0)).save(any(ItemEntity.class));
    }

    @Test
    void shouldReturnItemById() {
        when(itemRepository.findById(EXISTING_ITEM_ID)).thenReturn(Optional.of(itemEntity));

        var result = itemService.getItem(EXISTING_ITEM_ID);

        assertEquals(itemEntity, result);
    }

    @Test
    void shouldReturnAllItems() {
        List<ItemEntity> items = List.of(itemEntity);
        when(itemRepository.findAll()).thenReturn(items);

        var result = itemService.getAllItems();

        assertEquals(items, result);
    }

    @Test
    void shouldUpdateItem() {
        when(itemRepository.findById(EXISTING_ITEM_ID)).thenReturn(Optional.of(itemEntity));
        when(quantityService.doesQuantityExist(2)).thenReturn(true);
        when(quantityService.getQuantity(2)).thenReturn(quantityEntity);
        when(itemRepository.save(any(ItemEntity.class))).thenReturn(itemEntity);

        var updated = itemService.updateItem(EXISTING_ITEM_ID, "NewName", 2, category);

        assertEquals(itemEntity, updated);
    }

    @Test
    void shouldDeleteItem() {

        when(itemRepository.findById(EXISTING_ITEM_ID)).thenReturn(Optional.of(itemEntity));

        itemService.deleteItem(EXISTING_ITEM_ID);

        verify(itemRepository).delete(itemEntity);
    }
}