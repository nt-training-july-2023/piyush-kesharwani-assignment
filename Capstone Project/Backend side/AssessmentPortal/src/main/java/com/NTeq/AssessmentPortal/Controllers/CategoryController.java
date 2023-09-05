package com.NTeq.AssessmentPortal.Controllers;

import java.util.List;
import java.util.Optional;

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
import com.NTeq.AssessmentPortal.Services.impl.CategoryServiceImpl;

/**
 * Controller class that handles HTTP requests related to category operations.
 */
@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
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
    public final String saveCategory(final @RequestBody CategoryDto cgDto) {
        return categoryService.addCategory(cgDto);
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
        CategoryDto cg = categoryService.getCategoryById(id);
        if (cg == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(cg));
    }

    /**
     * End point to retrieve a list of all categories.
     * @return A list of category DTOs.
     */
    @GetMapping("/all")
    public final List<CategoryDto> getAll() {
        return categoryService.getAllCategory();

    }

    /**
     * End point to update a category by ID.
     * @param id    The ID of the category to update.
     * @param cgDto The updated category DTO.
     * @return The ResponseEntity containing the updated category DTO if
     *      successful,or INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @PutMapping("/update/{id}")
    public final ResponseEntity<CategoryDto> updateCategory(final
        @PathVariable("id") Long id, final @RequestBody CategoryDto cgDto) {
        try {
            categoryService.updateCategory(id, cgDto);
            return ResponseEntity.ok().body(cgDto);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .build();
        }
    }

    /**
     * End point to delete a category by ID.
     * @param id The ID of the category to delete.
     * @return The ResponseEntity indicating success with NO_CONTENT status
     *         INTERNAL_SERVER_ERROR status if an exception occurs.
     */
    @DeleteMapping("/delete/{id}")
    public final ResponseEntity<Void> deleteCategory(final @PathVariable("id")
                                                       Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR))
                    .build();
        }
    }
}
