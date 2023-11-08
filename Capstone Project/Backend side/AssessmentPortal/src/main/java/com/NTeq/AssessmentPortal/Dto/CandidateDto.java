package com.NTeq.AssessmentPortal.Dto;

import java.util.Objects;

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
    /**
     * Generates a hash code for this CandidateDto object.
     * @return The hash code value based on email, firstName, id, lastName,
     *         password, phoneNumber, and userRole properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, firstName, id, lastName, password,
                phoneNumber, userRole);
    }
    /**
     * Checks if this CandidateDto object is equal to another object.
     * @param obj The object to compare with.
     * @return {@code true} if objects are equal based on email, firstName,
     * id, lastName, password, phoneNumber, and userRole properties,
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CandidateDto other = (CandidateDto) obj;
        return Objects.equals(email, other.email)
                && Objects.equals(firstName, other.firstName) && id == other.id
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(password, other.password)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(userRole, other.userRole);
    }

}
