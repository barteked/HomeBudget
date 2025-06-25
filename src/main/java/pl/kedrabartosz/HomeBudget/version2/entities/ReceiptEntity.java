package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.Instant;

@Table(name = "receipt")
@Entity
public class ReceiptEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "purchased_at")
    private Instant purchasedAt;
    @Column(name = "total_cost")
    private double totalCost;
}
