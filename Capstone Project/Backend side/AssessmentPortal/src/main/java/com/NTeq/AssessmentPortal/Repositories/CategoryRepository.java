package com.NTeq.AssessmentPortal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Category;

/**
 * Repository interface for managing Category entities in the database.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
