package com.NTeq.AssessmentPortal.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String firstName;
    /**
     * The last name of the candidate.
     */
    @Column(nullable = false)
    private String lastName;
    /**
     * The email of the candidate.
     */
    @Column(nullable = false, unique = true)
    private String email;
    /**
     * The password of the candidate.
     */
    @Column(nullable = false)
    private String password;
    /**
     * The Role of the candidate.
     */
    private String userRole;
    /**
     * The phone number of the candidate.
     */
    private String phoneNumber;

}
