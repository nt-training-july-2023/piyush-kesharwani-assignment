package com.NTeq.AssessmentPortal.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
