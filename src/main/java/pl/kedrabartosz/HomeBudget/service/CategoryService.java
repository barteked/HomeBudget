package pl.kedrabartosz.HomeBudget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;

@Service
//service sie dodaje dla springa! nie jest to koniecznie bez tego tez by smigalo :D!
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService( @Autowired CategoryRepository categoryRepository) {
        // tu nastepuje wstrzykneicie zaleznosci!
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(String name) {
        return categoryRepository.save(name);
    }

    public Category updateCategory(String oldName, String newName) {
        return categoryRepository.update(oldName, newName);
    }

    public Category getCategory(String name) {
        return categoryRepository.getCategory(name);
    }


}
