package pl.kedrabartosz.HomeBudget.repository;

import java.util.Optional;

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
        int newId = categories.size() + 1;
        Category category = new Category(newId, name);
        categories.add(category);
        return category;
    }

    @Override
    public Optional<Category> update(String oldName, String newName) {
        Optional<Category> existingCategoryOptional = this.getCategory(oldName);
        existingCategoryOptional.ifPresent(category -> category.setName(newName));
        return existingCategoryOptional;

        /*
        if (existingCategoryOptional.isEmpty()){ // tu sprawdzasz, czu Optional nie jest pusty
            return Optional.empty();
        }
        Category category = existingCategoryOptional.get(); // tu wyciągamy wartość z Optionala (bo już wiemy, że istnieje)
        category.setName(newName); // tu updatujesz categorię
//        new Optional() - zakazane, tworzymy optionale przez .of() lub .ofNullable()
        return Optional.of(category); // tu zwracasz wynik
         */
    }

    @Override
    public Optional<Category> getCategory(String name) {
        return categories.stream()// tworzy strumien z listy category, jest to bezpieczniejsze! niz iterowanie po forze!
                .filter(category -> category.getName().equalsIgnoreCase(name))// filtruje elementy spelniajace warunek,
                // equalsIgnoreCase ignoruje czy to duza czy mala litera!, getname() to po prostu taka sama nazwa porownuje!
                .findFirst();// zwraca pierwszy element pasujacy --> 4. return Optional bo findFirst zwraca Optionala
        // co zwracać gdy nie ma co zwrócić:
        // 1. rzucić wyjątek
//                .orElseThrow(() -> new IllegalArgumentException("Can't find Category with this name " + name));
        // 2. zwrócić pusty obiekt (Null Pattern)
        //.orElse(Category.builder().build());
        // 3. najgorsza, zwrócić null
        //.orElse(null); // jesli nic nie znaleziono zwraca null tak sie nie robi!! nie zwraaca sie nulli!
        // 4. najbardziej pro - zwrócić Optionala - u nas po prostu .findFirst()

    }

    // jak wyglada hierarchia wyjatkow
    //czym sa pliki csv!
    @Override
    public Optional<Category> deleteCategory(String name) {
        Optional<Category> toRemoveOptional = getCategory(name);
        if (toRemoveOptional.isEmpty()) {
            return Optional.empty();
        }
        Category toRemoveCategory = toRemoveOptional.get();
        categories.remove(toRemoveCategory);
        return Optional.of(toRemoveCategory);
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(categories);
    }
}
