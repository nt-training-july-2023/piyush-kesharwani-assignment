package com.NTeq.AssessmentPortal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long resultId;
    private int totalMarks;
    private int obtainedMarks;
    private String userEmail;
    private String userName;
    private String dateTime;
    private String quizName;
    private String categoryName;
}
