package pl.kedrabartosz.HomeBudget.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;

import static org.junit.jupiter.api.Assertions.*;
import static pl.kedrabartosz.HomeBudget.service.MyTestCategoryRepository.CATEGORY_NAME;

class CategoryServiceTest {
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        CategoryRepository myTestCategoryRepository = new MyTestCategoryRepository();
        categoryService = new CategoryService(myTestCategoryRepository);
    }

    @Test
    public void shouldGetCategory() {
        //given

        String name = "Bartek";
        //when
        Category actual = categoryService.getCategory(name);
        //then
        Assertions.assertEquals(CATEGORY_NAME, actual.getName());
    }

}