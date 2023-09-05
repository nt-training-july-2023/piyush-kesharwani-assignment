package com.NTeq.AssessmentPortal.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {

    Category category;
    @BeforeEach
    void init() {
        category = new Category();
    }
    @Test
    void testGettersAndSetters() {
        assertEquals(0,category.getCategoryId());
        assertEquals(null, category.getCategoryName());
        assertEquals(null, category.getDescription());
        
        category.setCategoryId(10);
        category.setCategoryName("SpringBoot");
        category.setDescription("SpringBoot Description");
        assertEquals(10, category.getCategoryId());
        assertEquals("SpringBoot", category.getCategoryName());
        assertEquals("SpringBoot Description", category.getDescription());
    }
    @Test
    void testDefaultConstructor() {
        Category categoryObj = new Category();
        assertEquals(0,category.getCategoryId());
        assertEquals(null, categoryObj.getCategoryName());
        assertEquals(null, categoryObj.getDescription());
    }
    @Test
    void testParameterisedConstructor() {
        Category categoryObj = new Category(1L,"SpringBoot","SpringBoot Description");
        assertEquals(1L, categoryObj.getCategoryId());
        assertEquals("SpringBoot", categoryObj.getCategoryName());
        assertEquals("SpringBoot Description", categoryObj.getDescription());
    }

}
