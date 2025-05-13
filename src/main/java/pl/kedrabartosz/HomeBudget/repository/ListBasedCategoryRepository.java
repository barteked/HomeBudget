package pl.kedrabartosz.HomeBudget.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Repository;
import pl.kedrabartosz.HomeBudget.Category;

import java.io.FileNotFoundException;
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
        return categories.stream()// tworzy strumien z listy category, jest to bezpieczniejsze! niz iterowanie po forze!
                .filter(c -> c.getName().equalsIgnoreCase(name))// filtruje elementy spelniajace warunek,
                // equalsIgnoreCase ignoruje czy to duza czy mala litera!, getname() to po prostu taka sama nazwa porownuje!
                .findFirst()// zwraca pierwszy element pasujacy
                .orElseThrow(() -> new IllegalArgumentException("Can't find Category with this name " + name));
        //.orElse(Category.builder().build());
        //.orElse(null); // jesli nic nie znaleziono zwraca null tak sie nie robi!! nie zwraaca sie nulli!
    }

    // jak wyglada hierarchia wyjatkow
    //czym sa pliki csv!
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
