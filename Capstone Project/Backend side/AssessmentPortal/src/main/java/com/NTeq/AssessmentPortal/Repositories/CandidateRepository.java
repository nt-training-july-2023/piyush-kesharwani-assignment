package com.NTeq.AssessmentPortal.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Candidate;
/**
 * Repository interface for managing Candidate entities in the database.
 */
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    /**
     * Retrieves a candidate by their email.
     * @param email The email address of the candidate.
     * @return The candidate entity matching the given email,or null,not found.
     */
    Candidate getByEmail(String email);
    /**
     * Finds a candidate by their email.
     * @param email The email address of the candidate.
     * @return An optional containing the candidate entity matching the email.
     */
    Optional<Candidate> findByEmail(String email);

    /**
     * Finds a candidate by their email and password.
     * @param email           The email address of the candidate.
     * @param encodePassword Password to be encoded.
     * @return An optional containing the candidate entity matching the
     * given email and password.
     */
    Optional<Candidate> findByEmailAndPassword(String email,
            String encodePassword);

}
