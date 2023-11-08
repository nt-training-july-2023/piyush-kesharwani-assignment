package com.NTeq.AssessmentPortal.Dto;

import java.util.Objects;

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
    /**
     * Generates a hash code for this CategoryDto object.
     * @return The hash code value based on categoryId, categoryName,
     *  and description properties.
     */
    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, description);
    }
    /**
     * Checks if this CategoryDto object is equal to another object.
     * @param obj The object to compare with.
     * @return {@code true} if objects are equal based on categoryId,
     *          categoryName, and description properties,
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
        CategoryDto other = (CategoryDto) obj;
        return categoryId == other.categoryId
                && Objects.equals(categoryName, other.categoryName)
                && Objects.equals(description, other.description);
    }
}
