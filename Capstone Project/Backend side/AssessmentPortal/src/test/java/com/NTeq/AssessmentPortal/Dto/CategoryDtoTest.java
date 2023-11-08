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

    @Test
    void testEqualsAndHashcode() {
      
        CategoryDto categoryDto1 = new CategoryDto();
        categoryDto1.setCategoryId(1);
        categoryDto1.setCategoryName("SpringBoot");
        categoryDto1.setDescription("SpringBoot mcqs");
        
        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto2.setCategoryId(1);
        categoryDto2.setCategoryName("SpringBoot");
        categoryDto2.setDescription("SpringBoot mcqs");
        
        assertTrue(categoryDto1.equals(categoryDto1));
        assertFalse(categoryDto1.equals(null));
        assertFalse(categoryDto1.equals(""));
        
        assertTrue(categoryDto1.equals(categoryDto2));
        assertEquals(categoryDto1.hashCode(), categoryDto2.hashCode());
        
        categoryDto2.setCategoryName("Java");
        assertNotEquals(categoryDto1.hashCode(), categoryDto2.hashCode());
        assertFalse(categoryDto1.equals(categoryDto2));
        
        categoryDto2.setCategoryName("SpringBoot");
        categoryDto2.setDescription("Java mcqs");
        assertNotEquals(categoryDto1.hashCode(), categoryDto2.hashCode());
        assertFalse(categoryDto1.equals(categoryDto2));
    }
}
