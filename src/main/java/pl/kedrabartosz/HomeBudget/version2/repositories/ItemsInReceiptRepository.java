package pl.kedrabartosz.HomeBudget.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.version2.entities.ItemsInReceiptEntity;

@Repository
public interface ItemsInReceiptRepository extends JpaRepository<ItemsInReceiptEntity, Integer> {
}
