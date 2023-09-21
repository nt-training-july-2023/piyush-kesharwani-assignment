package com.NTeq.AssessmentPortal.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NTeq.AssessmentPortal.Entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long>{
   List<Result> findByUserEmail(String userEmail);
}
