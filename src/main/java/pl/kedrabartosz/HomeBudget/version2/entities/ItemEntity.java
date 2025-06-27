package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.*;

@Table(name = "item")
@Entity
public class ItemEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
    @OneToOne
    @JoinColumn(name = "quantity_id")
    private QuantityEntity quantityEntity;
}
