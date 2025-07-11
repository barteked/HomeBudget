package pl.kedrabartosz.HomeBudget.version1.repository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.version1.Person;
import pl.kedrabartosz.HomeBudget.version1.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@NoArgsConstructor
public class ListBasedReceiptRepository implements ReceiptRepository {
    private final List<Receipt> store = new ArrayList<>();

    @Override
    public Receipt save(Receipt receipt) {
        store.add(receipt);
        return receipt;
    }

    @Override
    public void delete(Receipt receipt) {
        store.remove(receipt);
    }

    @Override
    public List<Receipt> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public List<Receipt> findAllByPerson(Person person) {
        return store.stream()
                .filter(receipt -> receipt.getPerson().equals(person))
                .collect(Collectors.toList());
    }
}