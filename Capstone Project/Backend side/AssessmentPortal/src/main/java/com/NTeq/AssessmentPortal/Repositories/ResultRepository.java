package com.NTeq.AssessmentPortal.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Result;
/**
 * Repository interface for managing Result entities in the database.
 */
public interface ResultRepository extends JpaRepository<Result, Long> {
    /**
     * Retrieves a list of results for specific user's email address.
     *@param userEmail The email address of the user.
     * @return A list of Result objects associated with specified user's email.
     */
   List<Result> findByUserEmail(String userEmail);
}
