package pl.kedrabartosz.HomeBudget.version1.service;

import java.time.Instant;
import pl.kedrabartosz.HomeBudget.version1.Category;
import pl.kedrabartosz.HomeBudget.version1.Item;
import pl.kedrabartosz.HomeBudget.version1.Person;
import pl.kedrabartosz.HomeBudget.version1.Receipt;

import java.util.List;
import java.util.Optional;

public interface ReceiptService {

    Receipt saveNewReceipt(Person person, List<Item> products, Category category, Instant timeOfPurchase);

    Optional<Receipt> updateReceipt(Person person, Instant timeOfPurchase, String oldProduct, String newProduct, double newPrice);

    boolean removeReceipt(Person person, Instant timeOfPurchase);

    List<Receipt> getShoppingCarts(Person person);

    List<Receipt> getAllCarts();

}