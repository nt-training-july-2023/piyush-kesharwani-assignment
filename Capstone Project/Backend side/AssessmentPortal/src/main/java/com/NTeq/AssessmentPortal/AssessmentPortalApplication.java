package com.NTeq.AssessmentPortal;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssessmentPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssessmentPortalApplication.class, args);

    }

    @Bean
    public ModelMapper modelmapper() {
        return new ModelMapper();
    }

}

