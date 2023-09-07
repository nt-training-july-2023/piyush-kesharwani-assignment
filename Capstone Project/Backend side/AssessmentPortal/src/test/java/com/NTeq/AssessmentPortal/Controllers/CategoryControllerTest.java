package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Services.impl.CategoryServiceImpl;
@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryServiceImpl categoryService;

    @Test
    public void testSaveCategory() {
        CategoryDto categoryDto = new CategoryDto();
        // Set up categoryDto with appropriate data

        when(categoryService.addCategory(categoryDto)).thenReturn("Category added successfully");

        String response = categoryController.saveCategory(categoryDto);

        assertEquals("Category added successfully", response);
    }

    @Test
    public void testGetCategory_ExistingCategory() {
        long categoryId = 1L;
        CategoryDto categoryDto = new CategoryDto();
        // Set up categoryDto with appropriate data
        when(categoryService.getCategoryById(categoryId)).thenReturn(categoryDto);

        ResponseEntity<CategoryDto> responseEntity = categoryController.getCategory(categoryId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(categoryDto, responseEntity.getBody());
    }

    @Test
    public void testGetCategory_NonExistingCategory() {
        long categoryId = 2L;
        when(categoryService.getCategoryById(categoryId)).thenReturn(null);

        ResponseEntity<CategoryDto> responseEntity = categoryController.getCategory(categoryId);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testGetAllCategories() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        // Set up categoryDtoList with some data

        when(categoryService.getAllCategory()).thenReturn(categoryDtoList);

        List<CategoryDto> response = categoryController.getAll();

        assertEquals(categoryDtoList, response);
    }

    @Test
    public void testUpdateCategory_Success() {
        long categoryId = 1L;
        CategoryDto categoryDto = new CategoryDto();
        // Set up categoryDto with appropriate data

        ResponseEntity<CategoryDto> responseEntity = categoryController.updateCategory(categoryId, categoryDto);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(categoryDto, responseEntity.getBody());
    }

    @Test
    public void testUpdateCategory_Error() {
        long categoryId = 1L;
        CategoryDto categoryDto = new CategoryDto();
        // Set up categoryDto with appropriate data

        doThrow(new RuntimeException("Category update failed")).when(categoryService).updateCategory(categoryId, categoryDto);

        ResponseEntity<CategoryDto> responseEntity = categoryController.updateCategory(categoryId, categoryDto);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteCategory_Success() {
        long categoryId = 1L;

        ResponseEntity<Void> responseEntity = categoryController.deleteCategory(categoryId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testDeleteCategory_Error() {
        long categoryId = 1L;

        doThrow(new RuntimeException("Category deletion failed")).when(categoryService).deleteCategory(categoryId);

        ResponseEntity<Void> responseEntity = categoryController.deleteCategory(categoryId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
    }
}

