package com.example.schulhardwaremanagement.Service;

import com.example.schulhardwaremanagement.Entity.Benutzer;
import com.example.schulhardwaremanagement.Entity.Benutzergruppen;
import com.example.schulhardwaremanagement.Repository.BenutzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BenutzerService implements UserDetailsService {

    @Autowired
    private BenutzerRepository benutzerRepository;


    public Optional<String> findeBenutzerNameByEmail(String email) {
        return benutzerRepository.findByEmail(email)
                .map(benutzer -> benutzer.getVorname() + " " + benutzer.getName());
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Benutzer benutzer = benutzerRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Benutzer nicht gefunden: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Benutzergruppen gruppe : benutzer.getBenutzergruppen()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + gruppe.getBenutzergruppenName().toUpperCase()));
        }

        return new User(benutzer.getEmail(), benutzer.getPasswort(), authorities);
    }

    public String findUserDetailsByChipId(String chipID) {
        Optional<Benutzer> benutzer = getBenutzerByChipId(chipID);
        return benutzer.map(b -> b.getVorname() + " " + b.getName())
                .orElse("Benutzer nicht gefunden");
    }


    public Optional<Benutzer> findeBenutzerByEmail(String email){
     return benutzerRepository.findByEmail(email);
    }

    public Optional<Benutzer> findeBenutzerByChipId(String nuid) {
        return benutzerRepository.findByChipID(nuid);
    }


    public Optional<Benutzer> getBenutzerByChipId(String chipID) {
        return benutzerRepository.findByChipID(chipID);
    }
}

