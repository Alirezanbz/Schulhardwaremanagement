package com.example.schulhardwaremanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schulhardwaremanagement.Entity.Gegenstand;

public interface GegenstandRepository extends JpaRepository<Gegenstand, Integer> {


}
