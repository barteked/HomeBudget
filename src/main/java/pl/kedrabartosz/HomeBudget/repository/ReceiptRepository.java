package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Person;
import pl.kedrabartosz.HomeBudget.Receipt;

import java.util.List;

public interface ReceiptRepository {
    Receipt save(Receipt cart);

    List<Receipt> findAllByPerson(Person person);

    void delete(Receipt receipt);

    List<Receipt> findAll();
}
