package com.NTeq.AssessmentPortal.Controllers;

import static org.junit.jupiter.api.Assertions.*;
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
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
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
        SuccessResponse response = new SuccessResponse(HttpStatus.CREATED.value(),
                "Category created successfully.");

        when(categoryService.addCategory(categoryDto)).thenReturn(response);

        ResponseEntity<SuccessResponse> result = categoryController.saveCategory(categoryDto);
        assertEquals(HttpStatus.CREATED , result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    public void testGetCategory_ExistingCategory() {
        long categoryId = 1L;
        CategoryDto categoryDto = new CategoryDto();
        when(categoryService.getCategoryById(categoryId)).thenReturn(categoryDto);

        ResponseEntity<CategoryDto> responseEntity = categoryController.getCategory(categoryId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(categoryDto, responseEntity.getBody());
    }
    @Test
    public void testGetAllCategories() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        when(categoryService.getAllCategory()).thenReturn(categoryDtoList);

        List<CategoryDto> response = categoryController.getAll();

        assertEquals(categoryDtoList, response);
    }

    @Test
    public void testUpdateCategory_Success() {
        Long categoryId = 1L;
        CategoryDto categoryDto = new CategoryDto();
        SuccessResponse response = new SuccessResponse(HttpStatus.OK.value(),
                "Category updated successfully.");
        
        when(categoryService.updateCategory(categoryId, categoryDto)).thenReturn(response);

        ResponseEntity<SuccessResponse> result = categoryController.updateCategory(categoryId, categoryDto);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    public void testDeleteCategory_Success() {
        long categoryId = 1L;
        SuccessResponse response = new SuccessResponse(HttpStatus.OK.value(),
                "Category deleted successfully.");
        
        when(categoryService.deleteCategory(categoryId)).thenReturn(response);
        ResponseEntity<SuccessResponse> result = categoryController.deleteCategory(categoryId);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

}

