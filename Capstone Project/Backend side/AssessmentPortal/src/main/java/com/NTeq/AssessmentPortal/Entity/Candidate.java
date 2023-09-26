package com.NTeq.AssessmentPortal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a candidate's information stored in the database.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    /**
     * The unique ID of the candidate.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * The first name of the candidate.
     */
    @Column(nullable = false)
    @NotBlank(message = "First Name is required")
    private String firstName;
    /**
     * The last name of the candidate.
     */
    @Column(nullable = false)
    @NotBlank(message = "Last Name is required")
    private String lastName;
    /**
     * The email of the candidate.
     */
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[A-Z0-9a-z.+_-]+@nucleusTeq[.]com$",
    message = "Email is not Valid")
    private String email;
    /**
     * The password of the candidate.
     */
    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    private String password;
    /**
     * The Role of the candidate.
     */
    
    private String userRole;
    /**
     * The phone number of the candidate.
     */
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$" , message="phone number is invalid")
    private String phoneNumber;
}
