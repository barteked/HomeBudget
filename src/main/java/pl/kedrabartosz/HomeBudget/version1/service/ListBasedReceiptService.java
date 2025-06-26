package pl.kedrabartosz.HomeBudget.version1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.version1.Category;
import pl.kedrabartosz.HomeBudget.version1.Item;
import pl.kedrabartosz.HomeBudget.version1.Person;
import pl.kedrabartosz.HomeBudget.version1.Receipt;
import pl.kedrabartosz.HomeBudget.version1.repository.ReceiptRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListBasedReceiptService implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Override
    public Receipt saveNewReceipt(Person person, List<Item> products, Category category, Instant timeOfPurchase) {
        Receipt receipt = new Receipt(person, products, timeOfPurchase);
        return receiptRepository.save(receipt);
    }

    @Override
    public Optional<Receipt> updateReceipt(
            Person person,
            Instant timeOfPurchase,
            String oldProduct,
            String newProduct,
            double newPrice
    ) {

        Optional<Receipt> receiptOptional = receiptRepository.findAllByPerson(person).stream()
                .filter(receipt -> receipt.getTime().equals(timeOfPurchase))
                .findFirst();

        if (receiptOptional.isEmpty()) {
            return Optional.empty();
        }

        Receipt receipt = receiptOptional.get();

        receipt.getItems().stream()
                .filter(item -> item.getProduct().equalsIgnoreCase(oldProduct))
                .forEach(item -> {
                    item.setProduct(newProduct);
                    item.setPrice(newPrice);
                });

        return Optional.of(receipt);
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