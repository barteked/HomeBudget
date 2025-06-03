package pl.kedrabartosz.HomeBudget.service;

import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class MyTestCategoryRepository implements CategoryRepository {

    private static final int DEFAULT_ID = 1;
    public static final String CATEGORY_NAME = "tomek";

    @Override
    public Category save(String name) {
        return null;
    }

    @Override
    public Optional<Category> update(String oldName, String newName) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> getCategory(String name) {
        Category category = new Category(DEFAULT_ID, CATEGORY_NAME);
        Optional<Category> getCategoryOptional = Optional.of(category);
        return getCategoryOptional;
    }

    @Override
    public Optional<Category> deleteCategory(String name) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return List.of();
    }
}
