package com.example.schulhardwaremanagement.Config;
import com.example.schulhardwaremanagement.Service.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private BenutzerService benutzerService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http


                .authorizeRequests(authz -> authz
                        .requestMatchers("/", "/home", "/api/gegenstaende","/webjars/bootstrap/5.1.3/css/bootstrap.min.css","/webjars/jquery/3.6.0/jquery.min.js","/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js","/login").permitAll()
                        .requestMatchers("/warenkorb","/api/warenkorb/add","/api/benutzer/suchen").hasAuthority("ROLE_LEHRER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .permitAll()
                        .defaultSuccessUrl("/home", true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/home")
                )
                .csrf((httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                );


        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(benutzerService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }



}


