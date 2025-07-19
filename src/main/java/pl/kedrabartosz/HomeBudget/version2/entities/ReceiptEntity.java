package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.Instant;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "receipt")
@Entity
public class ReceiptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receipt_seq")
    @SequenceGenerator(name = "receipt_seq", sequenceName = "receipt_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "purchased_at")
    private Instant purchasedAt;
    @Column(name = "total_cost")
    private double totalCost;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;
}
