package pl.kedrabartosz.HomeBudget.version2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.kedrabartosz.HomeBudget.version2.entities.*;
import pl.kedrabartosz.HomeBudget.version2.repositories.ItemsInReceiptRepository;
import pl.kedrabartosz.HomeBudget.version2.repositories.ReceiptRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReceiptServiceTest {

    private ReceiptRepository receiptRepository;
    private PersonService personService;
    private ItemService itemService;
    private CostService costService;
    private ItemsInReceiptRepository itemsInReceiptRepository;

    private ReceiptService receiptService;

    @BeforeEach
    void setUp() {
        receiptRepository = mock(ReceiptRepository.class);
        personService = mock(PersonService.class);
        itemService = mock(ItemService.class);
        costService = mock(CostService.class);
        itemsInReceiptRepository = mock(ItemsInReceiptRepository.class);

        receiptService = new ReceiptService(receiptRepository, personService, itemService, costService, itemsInReceiptRepository);
    }

    @Test
    void shouldSaveReceiptAndCalculateTotalCostCorrectly() {
        // given
        int personId = 1;
        Instant date = Instant.now();

        PersonEntity person = PersonEntity.builder().id(personId).build();
        ItemEntity item = ItemEntity.builder().id(10).build();
        CostEntity cost = CostEntity.builder().price(5.0).build();

        List<ItemEntity> items = List.of(item, item);

        when(personService.getById(personId)).thenReturn(person);
        when(costService.getLatestCostForItem(10)).thenReturn(cost);
        when(receiptRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);

        // when
        ReceiptEntity result = receiptService.saveReceipt(personId, date, items);

        // then
        assertNotNull(result);
        assertEquals(10.0, result.getTotalCost());
        verify(receiptRepository).save(any());
        verify(itemsInReceiptRepository).save(any());
    }

    @Test
    void shouldReturnAllReceipts() {
        // given
        List<ReceiptEntity> mockList = List.of(new ReceiptEntity(), new ReceiptEntity());
        when(receiptRepository.findAll()).thenReturn(mockList);

        // when
        List<ReceiptEntity> result = receiptService.getAllReceipts();

        // then
        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnReceiptByIdWhenExists() {
        // given
        ReceiptEntity receipt = ReceiptEntity.builder().id(1).build();
        when(receiptRepository.findById(1)).thenReturn(Optional.of(receipt));

        // when
        ReceiptEntity result = receiptService.getReceiptById(1);

        // then
        assertNotNull(result);
        assertEquals(1, result.getId());
    }


    @Test
    void shouldReturnReceiptByExactDate() {
        // given
        Instant now = Instant.now();
        ReceiptEntity receipt = ReceiptEntity.builder().purchasedAt(now).build();
        when(receiptRepository.findAll()).thenReturn(List.of(receipt));

        // when
        ReceiptEntity result = receiptService.getReceiptByDate(now);

        // then
        assertNotNull(result);
        assertEquals(now, result.getPurchasedAt());
    }

    @Test
    void shouldThrowExceptionWhenCostIsMissingForItem() {
        // given
        int personId = 1;
        Instant date = Instant.now();

        ItemEntity item = ItemEntity.builder().id(10).build();

        List<ItemEntity> items = List.of(item);

        when(personService.getById(personId)).thenReturn(PersonEntity.builder().id(personId).build());
        when(costService.getLatestCostForItem(10)).thenReturn(null);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                receiptService.saveReceipt(personId, date, items));

        assertEquals("No cost found for item with ID: 10", exception.getMessage());
    }

}