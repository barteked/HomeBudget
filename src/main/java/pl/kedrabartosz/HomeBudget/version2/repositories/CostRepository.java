package pl.kedrabartosz.HomeBudget.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.version2.entities.CostEntity;

@Repository
public interface CostRepository extends JpaRepository<CostEntity, Integer> {
}
