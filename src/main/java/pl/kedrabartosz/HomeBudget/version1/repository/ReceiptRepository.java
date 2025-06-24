package pl.kedrabartosz.HomeBudget.version1.repository;

import pl.kedrabartosz.HomeBudget.version1.Person;
import pl.kedrabartosz.HomeBudget.version1.Receipt;

import java.util.List;

public interface ReceiptRepository {
    Receipt save(Receipt cart);

    List<Receipt> findAllByPerson(Person person);

    void delete(Receipt receipt);

    List<Receipt> findAll();
}
