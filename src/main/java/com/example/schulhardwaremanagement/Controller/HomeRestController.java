package com.example.schulhardwaremanagement.Controller;

import com.example.schulhardwaremanagement.DTO.GegenstandDto;
import com.example.schulhardwaremanagement.Entity.Gegenstand;
import com.example.schulhardwaremanagement.Service.GegenstandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
public class HomeRestController {

    @Autowired
    private GegenstandService gegenstandService;

    @GetMapping("/api/gegenstaende")
    public List<Gegenstand> getAllGegenstaende() {
        return gegenstandService.findAllGegenstaende();
    }

    @PostMapping("/api/add-gegenstand")
    public Gegenstand addGegenstand(@RequestBody GegenstandDto gegenstandDto) {
        return gegenstandService.addGegenstand(gegenstandDto);
    }

    @PutMapping("/{id}")
    public Gegenstand updateGegenstand(@PathVariable Integer id, @RequestBody Gegenstand gegenstand) {
        return gegenstandService.updateGegenstand(id, gegenstand);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGegenstand(@PathVariable Integer id) {
        gegenstandService.deleteGegenstand(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gegenstand> getGegenstandById(@PathVariable Integer id) {
        return gegenstandService.getGegenstandById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

