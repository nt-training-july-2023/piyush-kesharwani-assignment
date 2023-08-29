package com.NTeq.AssessmentPortal.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate getByEmail(String email);

    Optional<Candidate> findByEmail(String email);

    Optional<Candidate> findByEmailAndPassword(String email, String encodePassword);

}
