package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTeq.AssessmentPortal.Dto.CategoryDto;
import com.NTeq.AssessmentPortal.Dto.QuizDto;
import com.NTeq.AssessmentPortal.Services.impl.CategoryServiceImpl;

import jakarta.validation.Valid;

/**
 * Controller class that handles HTTP requests related to category operations.
 */
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    /**
     * This class represents a logger for the CategoryController.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CategoryController.class);
    /**
     * The CategoryService implementation that handles category operations.
     * This field is automatically injected by the @Autowired annotation.
     */
    @Autowired
    private CategoryServiceImpl categoryService;

    /**
     * End point to add a new category.
     * @param cgDto The category DTO containing category details.
     * @return A message indicating the addition status.
     */
    @PostMapping("/addCategory")
    public final String saveCategory(@Valid @RequestBody
            final CategoryDto cgDto) {
        LOGGER.info("Add category method invoke");
        String response =  categoryService.addCategory(cgDto);
        LOGGER.info("Category Added successfully");
        return response;
    }
    /**
     * End point to retrieve a category by ID.
     * @param id The ID of the category to retrieve.
     * @return The ResponseEntity containing the category DTO if found,
     * NOT_FOUND,status if not found.
     */
    @GetMapping("/getCategory/{id}")
    public final ResponseEntity<CategoryDto> getCategory(
           final @PathVariable("id") long id) {
        LOGGER.info("Received a request to get category with ID :{}", id);
        CategoryDto cg = categoryService.getCategoryById(id);
        LOGGER.info("successfully fetched category with ID {}", id);
        return ResponseEntity.of(Optional.of(cg));
    }

    /**
     * End point to retrieve a list of all categories.
     * @return A list of category DTOs.
     */
    @GetMapping("/all")
    public final List<CategoryDto> getAll() {
        LOGGER.info("Get Categories method invoke");
        List<CategoryDto> categories = categoryService.getAllCategory();
        LOGGER.info("Retrieved categories");
        return categories;
    }

    /**
     * End point to update a category by ID.
     * @param id    The ID of the category to update.
     * @param cgDto The updated category DTO.
     * @return The ResponseEntity containing the updated category DTO if
     * successful,or INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @PutMapping("/update/{id}")
    public final ResponseEntity<CategoryDto> updateCategory(final
        @PathVariable("id") Long id, @Valid final @RequestBody
        CategoryDto cgDto) {
        LOGGER.info("Received a request to update category with ID :{}", id);
        categoryService.updateCategory(id, cgDto);
        LOGGER.info("Category Updated successfully");
            return ResponseEntity.ok().body(cgDto);
    }

    /**
     * End point to delete a category by ID.
     * @param id The ID of the category to delete.
     * @return The ResponseEntity indicating success with NO_CONTENT status
     *         INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @DeleteMapping("/delete/{id}")
    public final ResponseEntity<String> deleteCategory(final @PathVariable("id")
           Long id) {
        LOGGER.info("Received a request to delete category with ID :{}", id);
        categoryService.deleteCategory(id);
        LOGGER.info("Deleted successfully");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    /**
     * Retrieves quizzes associated with a specific category.
     * @param id The category's unique identifier.
     * @return A list of QuizDto objects representing quizzes in the category.
     */
    @GetMapping("/{id}/quizzes")
    public final ResponseEntity<List<QuizDto>> getQuizzesByCategory(
            @PathVariable final long id) {
        LOGGER.info("Getting quizzes for category with ID: {}", id);
        List<QuizDto> quizzes = categoryService.getQuizzesByCategory(id);
        LOGGER.info("Quizzes retrieved successfully for category with ID: {}",
               id);
        return ResponseEntity.ok(quizzes);
    }
}
