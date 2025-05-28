package pl.kedrabartosz.HomeBudget.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kedrabartosz.HomeBudget.Category;
import pl.kedrabartosz.HomeBudget.repository.CategoryRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static pl.kedrabartosz.HomeBudget.service.MyTestCategoryRepository.CATEGORY_NAME;

class CategoryServiceTest {
    private CategoryService categoryService;
    @Mock
    private CategoryRepository myTestCategoryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryService(myTestCategoryRepository);
    }

    @Test
    public void shouldGetCategory() {
        //given
        Category category = new Category(CATEGORY_NAME);
        Optional<Category> getCategoryOptional = Optional.of(category);
        when(myTestCategoryRepository.getCategory(eq("Bartek"))).thenReturn(getCategoryOptional);
        String name = "Bartek";

        //when
        Category actual = categoryService.getCategory(name);
        //then
        Assertions.assertEquals(CATEGORY_NAME, actual.getName());
    }

}