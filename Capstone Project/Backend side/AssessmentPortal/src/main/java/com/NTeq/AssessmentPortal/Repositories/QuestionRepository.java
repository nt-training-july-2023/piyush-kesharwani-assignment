package com.NTeq.AssessmentPortal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Question;
/**
 * Repository interface for managing Question entities in the database.
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
