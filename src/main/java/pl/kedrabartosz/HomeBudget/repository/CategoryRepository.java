package pl.kedrabartosz.HomeBudget.repository;

import pl.kedrabartosz.HomeBudget.Category;

import java.util.List;

public interface CategoryRepository {
    Category save(String name);

    Category update(String oldName, String newName);

    Category getCategory(String name);

    Category deleteCategory(String name);

    List<Category> getAll();
}
