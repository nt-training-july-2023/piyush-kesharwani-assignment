package com.NTeq.AssessmentPortal.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long categoryId;

    private String categoryName;

    private String description;
}
