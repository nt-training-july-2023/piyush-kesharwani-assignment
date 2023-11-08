package com.NTeq.AssessmentPortal.Entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class OptionsTest {

    @Mock
    private Options options;

    @BeforeEach
    public void init() {
        options = new Options();
    }
    
    @Test
    public void testGetterSetter() {
        options.setOptionOne("java");
        options.setOptionTwo("python");
        options.setOptionThree("C++");
        options.setOptionFour("C");
        
        assertEquals("java" , options.getOptionOne());
        assertEquals("python" , options.getOptionTwo());
        assertEquals("C++" , options.getOptionThree());
        assertEquals("C" , options.getOptionFour());
    }
    
    @Test
    public void testAllArgsConstructor() {
        Options option = new Options("java","python","C++","C");
        
        assertEquals("java",option.getOptionOne());
        assertEquals("python",option.getOptionTwo());
        assertEquals("C++",option.getOptionThree());
        assertEquals("C",option.getOptionFour());
    }

}
