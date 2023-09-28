package com.NTeq.AssessmentPortal.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "First Name is required")
    private String firstName;

    /**
     * The lastName of the candidate.
     */
    @NotBlank(message = "Last Name is required")
    private String lastName;

    /**
     * The email of the candidate.
     */
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[A-Z0-9a-z.+_-]+@nucleusTeq[.]com$",
    message = "Email is not Valid")
    private String email;

    /**
     * The password of the candidate.
     */
    @NotBlank(message = "Password is required")
    private String password;

    /**
     * The role of the candidate.
     */
    private String userRole;

    /**
     * The phone number of the candidate.
     */
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "phone number is invalid")
    private String phoneNumber;

}
