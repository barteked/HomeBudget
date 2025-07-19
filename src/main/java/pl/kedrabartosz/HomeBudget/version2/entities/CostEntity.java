package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.*;
import java.util.Objects;

import lombok.*;

import java.time.Instant;
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "cost")
@Entity
public class CostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_seq")
    @SequenceGenerator(name = "cost_seq", sequenceName = "cost_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Getter
    @Column(name = "price")
    private double price;
    @Column(name = "effective_date")
    private Instant effectiveDate;
    @ManyToOne
    @JoinColumn(name = "item_id") // to jest fk
    private ItemEntity itemEntity;



    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        CostEntity that = (CostEntity) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(id, that.id) && Objects.equals(
            effectiveDate,
            that.effectiveDate
        ) && Objects.equals(itemEntity, that.itemEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, effectiveDate, itemEntity);
    }

    @Override
    public String toString() {
        return "CostEntity{" +
               "id=" + id +
               ", price=" + price +
               ", effectiveDate=" + effectiveDate +
               ", itemEntity=" + itemEntity +
               '}';
    }
}
