package pl.kedrabartosz.HomeBudget.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Builder
public class ListBasedCategoryRepository implements CategoryRepository {

    private List<Category> categories;

    @Override
    public Category save(String name) {
        Category category = new Category(name);
        categories.add(category);
        return category;
    }

    @Override
    public Category update(String oldName, String newName) {
        deleteCategory(oldName);
        return save(newName);
    }

    @Override
    public Category getCategory(String name) {
        return categories.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Category deleteCategory(String name) {
        Category toRemove = getCategory(name);
        categories.remove(toRemove);
        return toRemove;
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(categories);
    }
}
