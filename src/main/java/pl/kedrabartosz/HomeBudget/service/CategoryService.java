package pl.kedrabartosz.HomeBudget.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;

@Service
//service sie dodaje dla springa! nie jest to koniecznie bez tego tez by smigalo :D!
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        // tu nastepuje wstrzykneicie zaleznosci!
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(String name) {
        return categoryRepository.save(name);
    }

    public Category updateCategory(String oldName, String newName) {
        Optional<Category> updatedCategoryOptional = categoryRepository.update(oldName, newName);
        if (updatedCategoryOptional.isEmpty()) {
          System.out.println("Could not update category with oldName " + oldName);
          throw new IllegalArgumentException("Could not update category");
        }
        return updatedCategoryOptional.get();
    }

    public Category getCategory(String name) {
        Optional<Category> categoryOptional = categoryRepository.getCategory(name);
        if (categoryOptional.isEmpty()) {
          System.out.println("Could not get category with name " + name);
          throw new IllegalArgumentException("Could not get category");
        }
        return categoryOptional.get();
    }

    public Category deleteCategory(String name) {
        Optional<Category> deletedCategoryOptional = categoryRepository.deleteCategory(name);
        if (deletedCategoryOptional.isEmpty()) {
          System.out.println("Could not delete category with name " + name);
          throw new IllegalArgumentException("Could not delete category");
        }
        return deletedCategoryOptional.get();
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }
}
