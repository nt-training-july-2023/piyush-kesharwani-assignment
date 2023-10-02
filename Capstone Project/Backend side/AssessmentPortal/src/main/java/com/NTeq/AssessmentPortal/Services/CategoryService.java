package com.NTeq.AssessmentPortal.Services;

import java.util.List;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
/**
 * Service interface for managing category-related operations.
 */
public interface CategoryService {
    /**
     * Adds a new category to the system.
     * @param cgDto The DTO containing category details.
     * @return A message indicating the result of the operation.
     */
     SuccessResponse addCategory(CategoryDto cgDto);
    /**
     * Retrieves a list of all categories.
     * @return A list of category DTOs.
     */
    List<CategoryDto> getAllCategory();
    /**
     * Retrieves a category by its unique identifier.
     * @param categoryId The ID of the category to retrieve.
     * @return The DTO representing the retrieved category.
     */
    CategoryDto getCategoryById(long categoryId);
    /**
     * Updates a category's information.
     * @param categoryId The ID of the category to update.
     * @param cgDto      The DTO containing updated category details.
     * @return A message indicating the result of the operation.
     */
    SuccessResponse updateCategory(Long categoryId, CategoryDto cgDto);
    /**
     * Deletes a category by its unique identifier.
     * @param categoryId The ID of the category to delete.
     * @return A message indicating the delete operation.
     */
    SuccessResponse deleteCategory(long categoryId);
}


