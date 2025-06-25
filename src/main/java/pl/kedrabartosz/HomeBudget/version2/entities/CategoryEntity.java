package pl.kedrabartosz.HomeBudget.version2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.Instant;
@Table(name = "category")
@Entity
public class CategoryEntity {
@Id
@Column(name = "id")
private Integer id;
@Column(name = "name")
private String name;
@Column(name = "created_at")
private Instant createdAt;
@Column(name = "last_updated_at")
private Instant lastUpdatedAt;
}
