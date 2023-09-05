package com.NTeq.AssessmentPortal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main class that initializes the Assessment Portal application.
 */
@SpringBootApplication
public class AssessmentPortalApplication {

    /**
     * The main method to start the Assessment Portal application.
     * @param args The command line arguments passed to the application.
     */
    public static void main(final String[] args) {
        SpringApplication.run(AssessmentPortalApplication.class, args);

    }

    /**
     * Creates and configures a ModelMapper bean that can be used for object
     * mapping.
     * @return A configured ModelMapper instance.
     */
    @Bean
    ModelMapper modelmapper() {
        return new ModelMapper();
    }
}
