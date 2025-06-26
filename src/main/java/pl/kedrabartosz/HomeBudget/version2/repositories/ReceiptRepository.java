package pl.kedrabartosz.HomeBudget.version2.repositories;

import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.version2.entities.ReceiptEntity;

@Repository
public interface ReceiptRepository extends JpaRepository<ReceiptEntity, Integer> {
}
