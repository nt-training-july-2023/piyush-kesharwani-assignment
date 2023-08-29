package com.NTeq.AssessmentPortal.Configuraton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration class for security-related settings in the Assessment Portal
 * application. This class provides configuration beans related to password
 * encoding.
 */
@Configuration
public class SecurityConfiguration {
    /**
     * Creates and configures an instance of BCryptPasswordEncoder.
     *
     * @return A BCryptPasswordEncoder instance that used for secure password
     *         encoding.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
