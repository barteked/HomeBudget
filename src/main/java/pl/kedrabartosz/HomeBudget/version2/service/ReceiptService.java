package pl.kedrabartosz.HomeBudget.version2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.version2.entities.ReceiptEntity;
import pl.kedrabartosz.HomeBudget.version2.repositories.ReceiptRepository;

import java.time.Instant;
import java.util.List;

@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final PersonService personService;

    public ReceiptService(@Autowired ReceiptRepository receiptRepository,
                          @Autowired PersonService personService) {
        this.receiptRepository = receiptRepository;
        this.personService = personService;
    }

    public ReceiptEntity saveReceipt(int personId, Instant purchasedAt, double totalCost) {
        ReceiptEntity receipt = ReceiptEntity.builder()
                .purchasedAt(purchasedAt)
                .totalCost(totalCost)
                .personEntity(personService.getById(personId))
                .build();
        return receiptRepository.save(receipt);
    }

    public List<ReceiptEntity> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public ReceiptEntity getReceiptById(int receiptId) {
        return receiptRepository.findById(receiptId)
                .orElseThrow(() -> {
                    System.out.println("Could not find receipt with ID: " + receiptId);
                    return new IllegalArgumentException("Receipt not found");
                });
    }

    public ReceiptEntity getReceiptByDate(Instant date) {
        return receiptRepository.findAll().stream()
                .filter(r -> r.getPurchasedAt().equals(date))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No receipt found for date: " + date));
    }
}
