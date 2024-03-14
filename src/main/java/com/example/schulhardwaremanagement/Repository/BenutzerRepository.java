package com.example.schulhardwaremanagement.Repository;

import com.example.schulhardwaremanagement.Entity.Benutzer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BenutzerRepository extends JpaRepository<Benutzer, Integer> {

    Optional<Benutzer> findByEmail(String email);
}
