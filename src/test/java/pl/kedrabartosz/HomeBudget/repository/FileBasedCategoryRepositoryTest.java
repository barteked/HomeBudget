package pl.kedrabartosz.HomeBudget.repository;

import org.junit.jupiter.api.Test;
import pl.kedrabartosz.HomeBudget.version1.Category;
import pl.kedrabartosz.HomeBudget.version1.repository.CategoryRepository;
import pl.kedrabartosz.HomeBudget.version1.repository.FileBasedCategoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FileBasedCategoryRepositoryTest {
    private CategoryRepository fileBasedCategoryRepository = new FileBasedCategoryRepository();

    @Test
    public void shouldGetAll() {
        // given
        List<Category> expected = List.of(
                new Category(10, "Development"),
                new Category(11, "Food"),
                new Category(12, "Entertainment"),
                new Category(13, "Cleaning")
        );

        // when
        List<Category> actual = fileBasedCategoryRepository.getAll();

        // then
        assertIterableEquals(expected, actual);
    }

}
