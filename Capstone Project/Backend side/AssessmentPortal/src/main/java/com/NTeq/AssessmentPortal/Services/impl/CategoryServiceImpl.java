package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Services.CategoryService;

/**
 * Service implementation for managing category-related operations.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    /**
     * Repository for candidate data. Injected by Spring using @Autowired.
     */
    @Autowired
    private CategoryRepository categoryRepository;
  /**
   * Object mapper for DTO-entity mapping.Injected by Spring using @Autowired.
   */
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Adds a new category to the system.
     * @param cgDto The DTO containing category details.
     * @return A message indicating the result of the operation.
     */
    @Override
    public final String addCategory(final CategoryDto cgDto) {
        Category cg = this.dtoToCategory(cgDto);

        if (cg != null) {
            Category newOne = new Category(0L, cg.getCategoryName(),
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

    /**
     * Retrieves a list of all categories.
     * @return A list of category DTOs.
     */
    @Override
    public final List<CategoryDto> getAllCategory() {
        List<Category> cgs = this.categoryRepository.findAll();
        List<CategoryDto> cgDtos = cgs.stream()
                .map(category -> this.categoryToDto(category))
                .collect(Collectors.toList());
        return cgDtos;

    }

    /**
     * Retrieves a category by its unique identifier.
     * @param categoryId The ID of the category to retrieve.
     * @return The DTO representing the retrieved category.
     * @throws RuntimeException If the category is not found.
     */
    @Override
    public final CategoryDto getCategoryById(final long categoryId) {
        Optional<Category> foundCategory = categoryRepository
                .findById(categoryId);
        if (foundCategory.isPresent()) {
            Category cat = foundCategory.get();
            CategoryDto catDto = this.categoryToDto(cat);
            return catDto;
        } else {
            throw new RuntimeException(
                    "Category not found for id" + categoryId);
        }
    }

    /**
     * Updates a category's information.
     * @param categoryId The ID of the category to update.
     * @param cgDto      The DTO containing updated category details.
     * @return A message indicating the result of the operation.
     */
    @Override
    public final String updateCategory(final Long categoryId,
        final CategoryDto cgDto) {
        Category existCg = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFound("Doesn't exists"));
        if(!cgDto.getCategoryName().equals(existCg.getCategoryName())){
            Optional<Category> checkExisting = categoryRepository
                    .findByCategoryName(cgDto.getCategoryName());
            if(checkExisting.isPresent()) {
                throw new AlreadyExistException(
                      "Category with same name already exists");
            }
        }
        Category cg = this.dtoToCategory(cgDto);
        cg.setCategoryId(categoryId);
        categoryRepository.save(cg);
        return "Updated successfully..";
    }

    /**
     * Deletes a category by its unique identifier.
     * @param categoryId The ID of the category to delete.
     */
    @Override
    public final void deleteCategory(final long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    /**
     * Converts a Category entity to its corresponding DTO.
     * @param cg The Category entity.
     * @return The corresponding CategoryDto.
     */
    public final CategoryDto categoryToDto(final Category cg) {
        CategoryDto cdDto = modelMapper.map(cg, CategoryDto.class);
        return cdDto;
    }

    /**
     * Converts a CategoryDto to its corresponding entity.
     * @param cgDto The CategoryDto.
     * @return The corresponding Category entity.
     */
    public final Category dtoToCategory(final CategoryDto cgDto) {
        Category cg = this.modelMapper.map(cgDto, Category.class);
        return cg;
    }
}
