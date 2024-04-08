package com.example.schulhardwaremanagement.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String performLogin(@RequestParam String username, @RequestParam String password) {
        return "home";
    }


    @GetMapping("/api/auth")
    public ResponseEntity<Map<String, Object>> getAuthDetails(Authentication authentication) {
        Map<String, Object> authDetails = new HashMap<>();
        boolean isAuthenticated = authentication != null && authentication.isAuthenticated();
        boolean isTeacher = false;

        if (isAuthenticated && authentication.getAuthorities() != null) {
            isTeacher = authentication.getAuthorities().stream()
                    .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_LEHRER"));
        }

        authDetails.put("isAuthenticated", isAuthenticated);
        authDetails.put("isTeacher", isTeacher);

        return ResponseEntity.ok(authDetails);
    }





}
