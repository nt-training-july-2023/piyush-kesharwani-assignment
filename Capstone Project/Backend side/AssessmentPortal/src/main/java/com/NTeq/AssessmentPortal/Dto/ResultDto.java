package com.NTeq.AssessmentPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {

    private long resultId;
    private int totalMarks;
    private int obtainedMarks;
    private String userEmail;
    private String userName;
    private String dateTime;
    private String quizName;
    private String categoryName;
}
