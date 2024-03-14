package com.example.schulhardwaremanagement.Controller;

import com.example.schulhardwaremanagement.DTO.GegenstandDto;
import com.example.schulhardwaremanagement.Entity.Benutzer;
import com.example.schulhardwaremanagement.Entity.Gegenstand;
import com.example.schulhardwaremanagement.Service.BenutzerService;
import com.example.schulhardwaremanagement.Service.GegenstandService;
import com.example.schulhardwaremanagement.Warenkorb;
import com.example.schulhardwaremanagement.WarenkorbItems;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@RestController
public class HomeRestController {

    @Autowired
    private GegenstandService gegenstandService;

    @Autowired
    private BenutzerService benutzerService;

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

    @GetMapping("/api/warenkorb")
    public Warenkorb getWarenkorb(HttpSession session) {
        Warenkorb warenkorb = (Warenkorb) session.getAttribute("warenkorb");
        if (warenkorb == null) {
            warenkorb = new Warenkorb();
        }
        return warenkorb;
    }

    @PostMapping("/api/warenkorb/add")
    public ResponseEntity<Warenkorb> addToWarenkorb(HttpSession session, @RequestBody WarenkorbItems warenkorbItem) {
        Warenkorb warenkorb = (Warenkorb) session.getAttribute("warenkorb");
        if (warenkorb == null) {
            warenkorb = new Warenkorb();
        }
        warenkorb.addItem(warenkorbItem);
        session.setAttribute("warenkorb", warenkorb);
        return ResponseEntity.ok(warenkorb);
    }

    @GetMapping("/api/benutzer/suchen")
    public ResponseEntity<String> sucheBenutzerByEmail(@RequestParam String email) {
        Optional<String> benutzerNameOptional = benutzerService.findeBenutzerNameByEmail(email);
        return benutzerNameOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}

