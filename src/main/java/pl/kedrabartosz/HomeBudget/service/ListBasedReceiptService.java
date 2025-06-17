package pl.kedrabartosz.HomeBudget.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.Cost;
import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.Receipt;
import pl.kedrabartosz.HomeBudget.repository.ReceiptRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListBasedReceiptService implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Override
    public Receipt saveNewReceipt(Person person, List<Cost> products, Category category, Instant timeOfPurchase) {
        Receipt receipt = new Receipt(person, products, timeOfPurchase);
        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> updateReceipt(
            Person person, Instant timeOfPurchase, String oldProduct, String newProduct, double newPrice
    ) {
        Optional<Receipt> opt = receiptRepository.findAllByPerson(person).stream()
                .filter(r -> r.getTime().equals(timeOfPurchase))
                .findFirst();

        if (opt.isEmpty()) {
            return Optional.empty();
        }

        Receipt receipt = opt.get();

        receipt.getItems().stream()
                .filter(c -> c.getProduct().equalsIgnoreCase(oldProduct))
                .findFirst()
                .ifPresent(c -> {
                    c.setProduct(newProduct);
                    c.setPrice(newPrice);
                });

        return Optional.of(receiptRepository.save(receipt));
    }

    @Override
    public boolean removeReceipt(Person person, Instant timeOfPurchase) {
        Optional<Receipt> opt = receiptRepository.findAllByPerson(person).stream()
                .filter(r -> r.getTime().equals(timeOfPurchase))
                .findFirst();

        if (opt.isEmpty()) {
            return false;
        }

        receiptRepository.delete(opt.get());
        return true;
    }


    @Override
    public List<Receipt> getAllCarts() {
        return receiptRepository.findAll();
    }

    @Override
    public List<Receipt> getShoppingCarts(Person person) {
        return receiptRepository.findAllByPerson(person);
    }
}