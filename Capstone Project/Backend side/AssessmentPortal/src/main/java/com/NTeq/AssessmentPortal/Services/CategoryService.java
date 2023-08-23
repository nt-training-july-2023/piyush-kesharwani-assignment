package com.NTeq.AssessmentPortal.Services;

import java.util.List;

import com.NTeq.AssessmentPortal.Entity.Category;

public interface CategoryService {
	public String addCategory(Category cg);
	public List<Category> getAllCategory();
	public Category getCategoryById(Long categoryId);
}
