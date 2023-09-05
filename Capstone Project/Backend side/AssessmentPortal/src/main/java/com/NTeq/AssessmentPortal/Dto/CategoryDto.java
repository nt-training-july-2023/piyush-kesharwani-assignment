package com.NTeq.AssessmentPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) class representing a category's information.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    /**
     * The ID of the category.
     */
    private long categoryId;
    /**
     * The name of the category.
     */
    private String categoryName;
    /**
     * The description of the category.
     */
    private String description;
}
