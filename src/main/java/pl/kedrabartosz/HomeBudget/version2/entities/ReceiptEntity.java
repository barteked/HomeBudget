package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

import java.time.Instant;
@ToString
@Table(name = "receipt")
@Entity
public class ReceiptEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "person_id")
    private Integer personId;
    @Column(name = "purchased_at")
    private Instant purchasedAt;
    @Column(name = "total_cost")
    private double totalCost;
}
