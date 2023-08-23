package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public String addCategory(Category cg) {
		if(cg != null) {
			Category newOne = new Category(
					 0L,
					 cg.getCategoryName(),
					 cg.getDescription());
			
			try {
				categoryRepository.save(newOne);
				return "Category added successfully";
			} catch (Exception e) {
				throw e;
			}
		}
		return "Error!!!! Category not added..";
	}

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		 Optional<Category> foundCategory = categoryRepository.findById(categoryId);
		 if(foundCategory.isPresent()) {
			 Category cat = foundCategory.get();
			 return cat;
		 }else {
			 throw new RuntimeException("Category not found for id" + categoryId);
		 }
	}
	
	public String UpdateCategory(Long categoryId , Category cg) {
		cg.setCategoryId(categoryId);
		categoryRepository.save(cg);
		return "Updated successfully..";
	}
	
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

}
