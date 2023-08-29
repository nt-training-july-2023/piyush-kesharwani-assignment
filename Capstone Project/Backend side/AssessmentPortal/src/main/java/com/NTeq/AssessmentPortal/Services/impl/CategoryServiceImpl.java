package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String addCategory(CategoryDto cgDto) {
        Category cg = this.dtoToCategory(cgDto);

        if (cg != null) {
            Category newOne = new Category(0L, cg.getCategoryName(), cg.getDescription());

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
    public List<CategoryDto> getAllCategory() {
        List<Category> cgs = this.categoryRepository.findAll();
        List<CategoryDto> cgDtos = cgs.stream().map(category -> this.categoryToDto(category))
                .collect(Collectors.toList());
        return cgDtos;

    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Optional<Category> foundCategory = categoryRepository.findById(categoryId);
        if (foundCategory.isPresent()) {
            Category cat = foundCategory.get();
            CategoryDto catDto = this.categoryToDto(cat);
            return catDto;
        } else {
            throw new RuntimeException("Category not found for id" + categoryId);
        }
    }

    @Override
    public String UpdateCategory(Long categoryId, CategoryDto cgDto) {
        Category cg = this.dtoToCategory(cgDto);
        cg.setCategoryId(categoryId);
        categoryRepository.save(cg);
        return "Updated successfully..";
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public CategoryDto categoryToDto(Category cg) {
        CategoryDto cdDto = modelMapper.map(cg, CategoryDto.class);
        return cdDto;
    }

    public Category dtoToCategory(CategoryDto cgDto) {
        Category cg = this.modelMapper.map(cgDto, Category.class);
        return cg;
    }

}
