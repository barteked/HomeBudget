package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

import java.time.Instant;
@ToString
@Table(name = "cost")
@Entity
public class CostEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "price")
    private double price;
    @Column(name = "effective_date")
    private Instant effectiveDate;
    @Column(name = "item_id")
    private Integer itemId;
}
