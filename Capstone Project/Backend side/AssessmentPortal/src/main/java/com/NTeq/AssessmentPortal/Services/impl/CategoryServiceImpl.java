package com.NTeq.AssessmentPortal.Services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Entity.Category;
import com.NTeq.AssessmentPortal.Entity.Quiz;
import com.NTeq.AssessmentPortal.Exceptions.AlreadyExistException;
import com.NTeq.AssessmentPortal.Exceptions.ResourceNotFound;
import com.NTeq.AssessmentPortal.Repositories.CategoryRepository;
import com.NTeq.AssessmentPortal.Response.Message;
import com.NTeq.AssessmentPortal.Response.SuccessResponse;
import com.NTeq.AssessmentPortal.Services.CategoryService;
/**
 * Service implementation for managing category-related operations.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    /**
     * This class represents a logger for the CategoryServiceImpl.
     */
    private static final Logger LOGGER = LoggerFactory
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
     * @param categoryDto The DTO containing category details.
     * @return A message indicating the result of the operation.
     */
    @Override
    public final SuccessResponse addCategory(final CategoryDto categoryDto) {
        Category category = this.dtoToCategory(categoryDto);
            Category newOne = new Category(0L, category.getCategoryName(),
                    category.getDescription());
       Optional<Category> existingCategory = categoryRepository
               .findByCategoryName(category.getCategoryName());
       if (existingCategory.isPresent()) {
           LOGGER.error(Message.ALREADY_EXISTS);
           throw new AlreadyExistException(Message.ALREADY_EXISTS);
       }
            categoryRepository.save(newOne);
            return new SuccessResponse(HttpStatus.CREATED.value(),
                    Message.CATEGORY_CREATED_SUCCESSFULLY);
    }
    /**
     * Retrieves a list of all categories.
     * @return A list of category DTOs.
     */
    @Override
    public final List<CategoryDto> getAllCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(category -> this.categoryToDto(category))
                .collect(Collectors.toList());
        return categoryDtos;
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
            Category category = foundCategory.get();
            CategoryDto categoryDto = this.categoryToDto(category);
            return categoryDto;
        } else {
            LOGGER.error(Message.CATEGORY_NOT_FOUND);
            throw new ResourceNotFound(
                    Message.CATEGORY_NOT_FOUND);
        }
    }

    /**
     * Updates a category's information.
     * @param categoryId The ID of the category to update.
     * @param categoryDto      The DTO containing updated category details.
     * @return A message indicating the result of the operation.
     */
    @Override
    public final SuccessResponse updateCategory(final Long categoryId,
        final CategoryDto categoryDto) {
        Category existCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFound(
                        Message.CATEGORY_NOT_FOUND));
        if (!categoryDto.getCategoryName().equals(
                existCategory.getCategoryName())) {
            Optional<Category> checkExisting = categoryRepository
                    .findByCategoryName(categoryDto.getCategoryName());
            if (checkExisting.isPresent()) {
                LOGGER.error(Message.CATEGORY_ALREADY_EXISTS);
                throw new AlreadyExistException(
                      Message.CATEGORY_ALREADY_EXISTS);
            }
        }
        Category category = this.dtoToCategory(categoryDto);
        category.setCategoryId(categoryId);
        categoryRepository.save(category);
        return new SuccessResponse(HttpStatus.OK.value(),
                Message.CATEGORY_UPDATED_SUCCESSFULLY);
    }
    /**
     * Deletes a category by its unique identifier.
     * @param categoryId The ID of the category to delete.
     */
    @Override
    public final SuccessResponse deleteCategory(final long categoryId) {
        Category category
        = categoryRepository.findById(categoryId).orElseGet(() -> {
            LOGGER.error(Message.CATEGORY_NOT_FOUND);
            throw new ResourceNotFound(
                   Message.CATEGORY_NOT_FOUND + categoryId);
        });
            categoryRepository.delete(category);
            return new SuccessResponse(HttpStatus.OK.value(),
                    Message.CATEGORY_DELETED_SUCCESSFULLY);
    }
    /**
     * Retrieves a list of Quizzes of a category.
     * @param id The ID of the category.
     * @return List of QuizDTO objects.
     */
    public final List<QuizDto> getQuizzesByCategory(final long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(
                        Message.CATEGORY_NOT_FOUND + id));
        List<Quiz> quizzes = category.getQuiz();
        List<QuizDto> quizDtos = quizzes.stream().map(this::quizToDto)
                .collect(Collectors.toList());
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
