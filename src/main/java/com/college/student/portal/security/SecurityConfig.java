package com.college.student.portal.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig {

    private final JwtTokenFilter jwtTokenFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtTokenFilter jwtTokenFilter,
                          UserDetailsService userDetailsService) {
        this.jwtTokenFilter = jwtTokenFilter;
        this.userDetailsService = userDetailsService;
    }

    //  Password Encoder
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //  Authentication Manager
    @Bean
    AuthenticationManager authenticationManager(
        AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    //  Security Filter Chain
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF (JWT based)
            .csrf(csrf -> csrf.disable())

            // Enable CORS
            .cors(cors -> cors.configurationSource(request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(List.of("http://localhost:5173"));
                config.setAllowedMethods(
                        List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                config.setAllowedHeaders(List.of("*"));
                return config;
            }))

            // Tell Spring to use your UserDetailsService
            .userDetailsService(userDetailsService)

            // Authorization rules
            .authorizeHttpRequests(auth -> auth

            	    // Public APIs
            	    .requestMatchers(
            	        "/api/auth/**",
            	        "/swagger-ui/**",
            	        "/v3/api-docs/**",
            	        "/error",
            	        "/contact/**"
            	    ).permitAll()

            	    // Show all students
            	    .requestMatchers("/api/show/students")
            	        .hasAnyRole("ADMIN", "FACULTY")

            	    // Show single student
            	    .requestMatchers("/api/show/student/**")
            	        .hasAnyRole("ADMIN", "FACULTY", "STUDENT")

            	    // Update student
            	    .requestMatchers("/api/update/student/**")
            	        .hasAnyRole("ADMIN", "STUDENT")
            	        
            	    .requestMatchers("/api/admin/**")
            	       .hasAnyRole("ADMIN")
            	       
            	    .requestMatchers("/api/subjects/**")
            	     .hasAnyRole("ADMIN","FACULTY")
            	     
            	     .requestMatchers("/api/faculty/**")
            	     .hasAnyRole("ADMIN","FACULTY")
            	       
            	    .requestMatchers("/api/subjects/**")
            	    .hasAnyRole("FACULTY","ADMIN")
            	    
            	    .requestMatchers("/api/students/**")
            	    .hasAnyRole("STUDENT")
            	    
            	    .requestMatchers("/api/courses/**")
            	    .hasAnyRole("ADMIN","FACULTY")
            	    
            	    .requestMatchers("/api/notices/**")
            	    .hasAnyRole("STUDENT")

            	    // Everything else
            	    .anyRequest().authenticated()
            	)

            // Stateless session (JWT)
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        // JWT filter
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
