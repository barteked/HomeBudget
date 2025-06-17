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

    private final CategoryService categoryService;
    private final CostService costService;
    private final ReceiptRepository receiptRepository;

    @Override
    public Receipt saveNewReceipt(Person person, List<Cost> products, Category category, Instant timeOfPurchase) {
     // todo
    }

    @Override
    public Optional<Receipt> updateReceipt(
        Person person, Instant timeOfPurchase, String oldProduct, String newProduct, double newPrice
    ) {
        // todo - rozpoznajesz po tym ze receipt.person equals person && receipt.date == timeOfPurchase
    }

    @Override
    public boolean removeReceipt(Person person, Instant timeOfPurchase) {
        // todo
    }


    @Override
    public List<Receipt> getAllCarts() {
      // todo
    }

    @Override
    public List<Receipt> getShoppingCarts(Person person) {
        return receiptRepository.findAllByPerson(person);
    }
}