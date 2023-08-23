package com.NTeq.AssessmentPortal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}

