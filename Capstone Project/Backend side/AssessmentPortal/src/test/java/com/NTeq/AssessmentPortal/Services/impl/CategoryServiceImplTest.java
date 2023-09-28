package com.NTeq.AssessmentPortal.Services.impl;

import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;

class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testAddCategory() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName("Test Category");

        Category category = new Category();
        category.setCategoryName("Test Category");

        when(modelMapper.map(categoryDto, Category.class)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);

        String resultMessage = categoryService.addCategory(categoryDto);
        assertEquals("Category added successfully", resultMessage);
    }
    @Test
    public void testGetCategoryById_Success() {
        int categoryId = 1;

        Category category = new Category();
        category.setCategoryId(categoryId);
        category.setCategoryName("Test Category");

        CategoryDto expectedDto = new CategoryDto();
        expectedDto.setCategoryId(categoryId);
        expectedDto.setCategoryName("Test Category");

        when(categoryRepository.findById((long) categoryId)).thenReturn(Optional.of(category));
        when(modelMapper.map(category, CategoryDto.class)).thenReturn(expectedDto);

        CategoryDto resultDto = categoryService.getCategoryById(categoryId);
        assertEquals(expectedDto, resultDto);
    }
    
    @Test
    public void testGetCategoryById_CategoryNotFound() {
        int categoryId = 1;

        when(categoryRepository.findById((long) categoryId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> categoryService.getCategoryById(categoryId));
    }
    
    @Test
    public void testGetAllCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category());
        categories.add(new Category());

        when(categoryRepository.findAll()).thenReturn(categories);

        CategoryDto dto1 = new CategoryDto();
        CategoryDto dto2 = new CategoryDto();

        when(modelMapper.map(categories.get(0), CategoryDto.class)).thenReturn(dto1);
        when(modelMapper.map(categories.get(1), CategoryDto.class)).thenReturn(dto2);

        List<CategoryDto> result = categoryService.getAllCategory();
        assertEquals(2, result.size());
        assertEquals(dto1, result.get(0));
        assertEquals(dto2, result.get(1));
    }
    
    @Test
    void testDeleteCategory() {
        long categoryId = 1L;
        Category category = new Category();
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));
        assertDoesNotThrow(() -> categoryService.deleteCategory(categoryId));
    }
    
    @Test
    public void testUpdateCategory_Success() {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(5);
        categoryDto.setCategoryName("Updated Category");

        Category existingCategory = new Category();
        existingCategory.setCategoryId(5);
        existingCategory.setCategoryName("Original Category");

        Category updatedCategory = new Category();
        updatedCategory.setCategoryId(5);
        updatedCategory.setCategoryName("Updated Category");

        when(categoryRepository.findById((long) 5)).thenReturn(Optional.of(existingCategory));
        when(modelMapper.map(categoryDto, Category.class)).thenReturn(updatedCategory);
        when(categoryRepository.save(updatedCategory)).thenReturn(updatedCategory);

        String resultDto = categoryService.updateCategory(5L,categoryDto);
        assertEquals("Updated successfully..", resultDto);
    }
    @Test
    public void testGetQuizzesByCategory() {
        CategoryDto category = new CategoryDto();
        category.setCategoryId(1);
        category.setCategoryName("Test Category");
        category.setDescription("Test Description");
        Category categoryEntity = new Category();
        categoryEntity.setCategoryId(1);
        categoryEntity.setCategoryName("Test Category");
        categoryEntity.setDescription("Test Description");
        List<Quiz> quizzes = new ArrayList<Quiz>();
        Quiz quiz = new Quiz(1, "Title", "Description",categoryEntity, 20);
        quiz.setCategory(categoryEntity);
        QuizDto quizDTO = new QuizDto(1, "Title", "Description",category, 20);
        quizDTO.setCategory(category);
        quizzes.add(quiz);
        categoryEntity.setQuiz(quizzes);
        when(modelMapper.map(categoryEntity, CategoryDto.class))
                .thenReturn(category);
        when(modelMapper.map(category, Category.class))
                .thenReturn(categoryEntity);
        when(categoryService.quizToDto(quiz)).thenReturn(quizDTO);
        when(categoryRepository.findById(category.getCategoryId()))
                .thenReturn(Optional.of(categoryEntity));
        List<QuizDto> result = categoryService
                .getQuizzesByCategory(category.getCategoryId());
        assertEquals(1, result.size());
    }
}
