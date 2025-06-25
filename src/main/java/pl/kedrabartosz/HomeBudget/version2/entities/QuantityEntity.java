package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "quantity")
@Entity
public class QuantityEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "value")
    private String value;
}
