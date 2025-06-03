package pl.kedrabartosz.HomeBudget.repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import pl.kedrabartosz.HomeBudget.Category;

import java.util.List;

public interface CategoryRepository {
    Category save(String name);

    Optional<Category> update(String oldName, String newName);

    Optional<Category> getCategory(String name);

    Optional<Category> deleteCategory(String name);

    List<Category> getAll();
}
