package pl.kedrabartosz.HomeBudget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Builder
@Data
@AllArgsConstructor
public class Category {
    private int id;
    private String name;


}
