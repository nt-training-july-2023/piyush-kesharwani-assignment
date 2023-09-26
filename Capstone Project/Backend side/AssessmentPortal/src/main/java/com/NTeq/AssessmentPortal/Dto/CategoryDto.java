package com.NTeq.AssessmentPortal.Dto;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Category name are required")
    private String categoryName;
    /**
     * The description of the category.
     */
    @NotBlank(message = "description are required")
    private String description;
}
