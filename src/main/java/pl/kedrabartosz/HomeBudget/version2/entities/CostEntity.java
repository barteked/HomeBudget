package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.*;

import java.time.Instant;

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
    @ManyToOne
    @JoinColumn(name = "item_id") // to jest fk
    private ItemEntity itemEntity;
}
