package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Table(name = "items_in_receipt")
@Entity
public class ItemsInReceiptEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "receipt_id")
    private Integer receiptId;
}
