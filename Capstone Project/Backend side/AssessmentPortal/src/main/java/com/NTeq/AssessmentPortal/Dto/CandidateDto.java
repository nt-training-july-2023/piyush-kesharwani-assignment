package com.NTeq.AssessmentPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a candidate's information.
 */
@Getter
@Setter
@AllArgsConstructor
public class CandidateDto {
    /**
     * Default constructor for creating a CandidateDto.
     */
    public CandidateDto() {

    }

    /**
     * The ID of the candidate.
     */
    private long id;

    /**
     * The first name of the candidate.
     */
    private String firstName;

    /**
     * The lastName of the candidate.
     */
    private String lastName;

    /**
     * The email of the candidate.
     */
    private String email;

    /**
     * The password of the candidate.
     */
    private String password;

    /**
     * The role of the candidate.
     */
    private String userRole;

    /**
     * The phone number of the candidate.
     */
    private String phoneNumber;

}
