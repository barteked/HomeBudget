package pl.kedrabartosz.HomeBudget.version2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.version2.entities.CostEntity;
import pl.kedrabartosz.HomeBudget.version2.entities.ItemEntity;
import pl.kedrabartosz.HomeBudget.version2.entities.ItemsInReceiptEntity;
import pl.kedrabartosz.HomeBudget.version2.entities.ReceiptEntity;
import pl.kedrabartosz.HomeBudget.version2.repositories.ItemsInReceiptRepository;
import pl.kedrabartosz.HomeBudget.version2.repositories.ReceiptRepository;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final PersonService personService;
    private final ItemService itemService;
    private final CostService costService;
    private final ItemsInReceiptRepository itemsInReceiptRepository;

    public ReceiptService(@Autowired ReceiptRepository receiptRepository,
                          @Autowired PersonService personService,
                          @Autowired ItemService itemService,
                          @Autowired CostService costService,
                          @Autowired ItemsInReceiptRepository itemsInReceiptRepository) {
        this.receiptRepository = receiptRepository;
        this.personService = personService;
        this.itemService = itemService;
        this.costService = costService;
        this.itemsInReceiptRepository = itemsInReceiptRepository;
    }

    public ReceiptEntity saveReceipt(int personId, Instant purchasedAt, Map<Integer, Integer> itemsWithQuantities) {
        double totalCost = 0.0;

        for (Map.Entry<Integer, Integer> entry : itemsWithQuantities.entrySet()) {
            int itemId = entry.getKey();
            int quantity = entry.getValue();

            CostEntity cost = costService.getLatestCostForItem(itemId);
            if (cost == null) {
                throw new IllegalArgumentException("No cost found for item with ID: " + itemId);
            }
            totalCost += cost.getPrice() * quantity;
        }

        ReceiptEntity receipt = ReceiptEntity.builder()
                .purchasedAt(purchasedAt)
                .personEntity(personService.getById(personId))
                .totalCost(totalCost)
                .build();

        ReceiptEntity savedReceipt = receiptRepository.save(receipt);

        for (Map.Entry<Integer, Integer> entry : itemsWithQuantities.entrySet()) {
            ItemEntity item = itemService.getItem(entry.getKey());
            int quantity = entry.getValue();

            ItemsInReceiptEntity link = ItemsInReceiptEntity.builder()
                    .itemEntity(item)
                    .receiptEntity(savedReceipt)
                    .quantity(quantity)
                    .build();

            itemsInReceiptRepository.save(link);
        }

        return savedReceipt;
    }

    public List<ReceiptEntity> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public ReceiptEntity getReceiptById(int receiptId) {
        return receiptRepository.findById(receiptId)
                .orElseThrow(() -> new IllegalArgumentException("Receipt not found with ID: " + receiptId));
    }

    public ReceiptEntity getReceiptByDate(Instant date) {
        return receiptRepository.findAll().stream()
                .filter(r -> r.getPurchasedAt().equals(date))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No receipt found for date: " + date));
    }
}