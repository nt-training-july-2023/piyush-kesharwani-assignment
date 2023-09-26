package com.NTeq.AssessmentPortal.Entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Entity class representing a options of Question class.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Options {
    /**
     * The optionI of the question.
     */
    @NotBlank(message = "Option one is required")
    private String optionOne;
    /**
     * The optionII of the question.
     */
    @NotBlank(message = "Option Two is required")
    private String optionTwo;
    /**
     * The optionIII of the question.
     */
    @NotBlank(message = "Option Three is required")
    private String optionThree;
    /**
     * The optionIV of the question.
     */
    @NotBlank(message = "Option four is required")
    private String optionFour;
}

