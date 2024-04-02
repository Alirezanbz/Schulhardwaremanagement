package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Benutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer benutzerID;
    private String chipID;
    private String passwort;
    private String name;
    private String vorname;
    private String email;
    private String klasse;

    @ManyToMany
    @JoinTable(
            name = "Benutzer_Benutzergruppen",
            joinColumns = @JoinColumn(name = "benutzerID"),
            inverseJoinColumns = @JoinColumn(name = "benutzergruppenID"))
    private Set<Benutzergruppen> benutzergruppen;


    public Integer getBenutzerID() {
        return benutzerID;
    }

    public void setBenutzerID(Integer benutzerID) {
        this.benutzerID = benutzerID;
    }

    public String getChipID() {
        return chipID;
    }

    public void setChipID(String chipID) {
        this.chipID = chipID;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public Set<Benutzergruppen> getBenutzergruppen() {
        return benutzergruppen;
    }

    public void setBenutzergruppen(Set<Benutzergruppen> benutzergruppen) {
        this.benutzergruppen = benutzergruppen;
    }
}