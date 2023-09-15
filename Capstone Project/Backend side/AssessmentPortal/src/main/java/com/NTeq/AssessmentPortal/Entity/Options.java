package com.NTeq.AssessmentPortal.Entity;

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
    private String optionOne;
    /**
     * The optionII of the question.
     */
    private String optionTwo;
    /**
     * The optionIII of the question.
     */
    private String optionThree;
    /**
     * The optionIV of the question.
     */
    private String optionFour;
}

