package pl.kedrabartosz.HomeBudget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Category {
    private String name;
}
