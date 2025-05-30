package pl.kedrabartosz.HomeBudget.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kedrabartosz.HomeBudget.Category;

import java.util.List;

public class FileBasedCategoryRepositoryTest {
    private CategoryRepository fileBasedCategoryRepository = new FileBasedCategoryRepository();

    @Test
    public void shouldGetAll() {
        //given

        //when
        List<Category> actual = fileBasedCategoryRepository.getAll();
        //then
        Assertions.assertEquals(4, actual.size());
        Assertions.assertEquals("Development", actual.get(0).getName());
        Assertions.assertEquals(10, actual.get(0).getId());

        Assertions.assertEquals(4, actual.size());
        Assertions.assertEquals("Food", actual.get(1).getName());
        Assertions.assertEquals(11, actual.get(1).getId());

        Assertions.assertEquals(4, actual.size());
        Assertions.assertEquals("Entertainment", actual.get(2).getName());
        Assertions.assertEquals(12, actual.get(2).getId());

        Assertions.assertEquals(4, actual.size());
        Assertions.assertEquals("Cleaning", actual.get(3).getName());
        Assertions.assertEquals(13, actual.get(3).getId());
    }

}
