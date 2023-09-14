package com.NTeq.AssessmentPortal.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Category;

/**
 * Repository interface for managing Category entities in the database.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Retrieves a category by its title.
     * @param categoryName The Name of the category to retrieve.
     * @return An Optional containing the retrieved Category entity, if found.
     */
    Optional<Category> findByCategoryName(String categoryName);
}
