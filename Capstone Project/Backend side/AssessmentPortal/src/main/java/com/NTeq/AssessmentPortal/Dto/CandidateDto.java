package com.NTeq.AssessmentPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateDto {

    public CandidateDto() {

    }

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userRole;
    private String phoneNumber;

}
