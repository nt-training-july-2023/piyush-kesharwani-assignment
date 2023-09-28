package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Services.CategoryService;
/**
 * Service implementation for managing category-related operations.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final Logger LOGGER = LoggerFactory
            .getLogger(CategoryServiceImpl.class);
    /**
     * Repository for category data. Injected by Spring using @Autowired.
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
        LOGGER.info("Adding a new category: {}", cgDto.getCategoryName());
        Category cg = this.dtoToCategory(cgDto);
            Category newOne = new Category(0L, cg.getCategoryName(),
                    cg.getDescription());

                categoryRepository.save(newOne);
                LOGGER.info("Category added successfully: {}", newOne.getCategoryName());
                return "Category added successfully";
    }
    /**
     * Retrieves a list of all categories.
     * @return A list of category DTOs.
     */
    @Override
    public final List<CategoryDto> getAllCategory() {
        LOGGER.info("Getting all categories");

        List<Category> cgs = this.categoryRepository.findAll();
        List<CategoryDto> cgDtos = cgs.stream()
                .map(category -> this.categoryToDto(category))
                .collect(Collectors.toList());

        LOGGER.info("Retrieved {} categories", cgDtos.size());
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
        LOGGER.info("Getting category by ID: {}", categoryId);
        Optional<Category> foundCategory = categoryRepository
                .findById(categoryId);
        if (foundCategory.isPresent()) {
            Category cat = foundCategory.get();
            CategoryDto catDto = this.categoryToDto(cat);
            LOGGER.info("Retrieved category: {}", catDto.getCategoryName());
            return catDto;
        } else {
            LOGGER.error("Category not found for ID: {}", categoryId);
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
        LOGGER.info("Updating category with ID: {}", categoryId);
        Category existCg = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFound("Doesn't exists"));
        if (!cgDto.getCategoryName().equals(existCg.getCategoryName())) {
            Optional<Category> checkExisting = categoryRepository
                    .findByCategoryName(cgDto.getCategoryName());
            if (checkExisting.isPresent()) {
                LOGGER.error("Category with the same name already exists: {}"
                        , cgDto.getCategoryName());
                throw new AlreadyExistException(
                      "Category with same name already exists");
            }
        }
        Category cg = this.dtoToCategory(cgDto);
        cg.setCategoryId(categoryId);
        categoryRepository.save(cg);
        LOGGER.info("Category updated successfully");
        return "Updated successfully..";
    }
    /**
     * Deletes a category by its unique identifier.
     * @param categoryId The ID of the category to delete.
     */
    @Override
    public final String deleteCategory(final long categoryId) {
//        categoryRepository.deleteById(categoryId);
        LOGGER.info("Deleting category by ID: {}", categoryId);
        Category category
        = categoryRepository.findById(categoryId).orElseGet(() -> {
            LOGGER.error("Category not found for ID: {}", categoryId);
            throw new ResourceNotFound(
                    "Category doesn't exists" + categoryId);
        });
            categoryRepository.delete(category);
            LOGGER.error("Category not found for ID: {}", categoryId);
            return "Category has been deleted";
    }
    /**
     * Retrieves a list of Quizzes of a category.
     * @param id The ID of the category.
     * @return List of QuizDTO objects.
     */
    public final List<QuizDto> getQuizzesByCategory(final long id) {
        LOGGER.info("Getting quizzes for category with ID: {}", id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(
                        "*category doesn't exist with id: " + id));
        List<Quiz> quizzes = category.getQuiz();
        List<QuizDto> quizDtos = quizzes.stream().map(this::quizToDto).collect(Collectors.toList());

        LOGGER.info("Retrieved {} quizzes for category with ID: {}", quizDtos.size(), id);
        return quizDtos;
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
    /**
     * Converts a quiz entity to its corresponding DTO.
     * @param quiz The Quiz entity.
     * @return The corresponding QuizDto.
     */
    public final QuizDto quizToDto(final Quiz quiz) {
        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
        return quizDto;
    }
}
