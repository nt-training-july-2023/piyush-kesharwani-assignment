package com.NTeq.AssessmentPortal.Services;

import java.util.List;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;

public interface CategoryService {
    public String addCategory(CategoryDto cgDto);

    public List<CategoryDto> getAllCategory();

    public CategoryDto getCategoryById(Long categoryId);

    public String UpdateCategory(Long categoryId, CategoryDto cgDto);

    public void deleteCategory(Long categoryId);
}
