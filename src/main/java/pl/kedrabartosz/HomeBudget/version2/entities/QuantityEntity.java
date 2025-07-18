package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "quantity")
@Entity
public class QuantityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quantity_seq")
    @SequenceGenerator(name = "quantity_seq", sequenceName = "quantity_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "value")
    private String value;
}
