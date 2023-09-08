package com.NTeq.AssessmentPortal.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Quiz;

/**
 * Repository interface for managing Quiz entities in the database.
 */
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    /**
     * Find a quiz by its name.
     * @param quizName The name of the quiz to find.
     * @return An optional containing the quiz if found, or an empty optional
     * if not found.
     */
    Optional<Quiz> findByQuizName(String quizName);
}
