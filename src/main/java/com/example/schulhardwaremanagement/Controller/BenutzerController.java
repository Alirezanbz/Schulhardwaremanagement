package com.example.schulhardwaremanagement.Controller;

import com.example.schulhardwaremanagement.Service.BenutzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BenutzerController {

    @Autowired
    private BenutzerService benutzerService;

    @GetMapping("/benutzer/{chipID}")
    public ResponseEntity<String> getBenutzerByChipId(@PathVariable String chipID) {
        System.out.println("Received chip ID from serial reader: " + chipID);
        String userDetails = benutzerService.findUserDetailsByChipId(chipID);
        return ResponseEntity.ok().body(userDetails);
    }


}
