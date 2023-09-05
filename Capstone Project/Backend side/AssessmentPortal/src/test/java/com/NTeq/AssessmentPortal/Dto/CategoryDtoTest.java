package com.NTeq.AssessmentPortal.Dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CategoryDtoTest {

    CategoryDto categoryDto;
    @BeforeEach
    void init() {
        categoryDto = new CategoryDto();
    }
    
    @Test
    void testallGettersAndSetters() {
        assertEquals(0,categoryDto.getCategoryId());
        assertEquals(null, categoryDto.getCategoryName());
        assertEquals(null, categoryDto.getDescription());
        
        categoryDto.setCategoryId(10);
        categoryDto.setCategoryName("SpringBoot");
        categoryDto.setDescription("SpringBoot Description");
        assertEquals(10, categoryDto.getCategoryId());
        assertEquals("SpringBoot", categoryDto.getCategoryName());
        assertEquals("SpringBoot Description", categoryDto.getDescription());
    }
    @Test
    void testDefaultConstructor() {
        CategoryDto categoryDtoObj = new CategoryDto();
        assertEquals(0,categoryDtoObj.getCategoryId());
        assertEquals(null, categoryDtoObj.getCategoryName());
        assertEquals(null, categoryDtoObj.getDescription());
    }
    @Test
    void testParameterisedConstructor() {
        CategoryDto categoryDtoObj = new CategoryDto(1L,"SpringBoot","SpringBoot Description");
        assertEquals(1L, categoryDtoObj.getCategoryId());
        assertEquals("SpringBoot", categoryDtoObj.getCategoryName());
        assertEquals("SpringBoot Description", categoryDtoObj.getDescription());
    }

}
