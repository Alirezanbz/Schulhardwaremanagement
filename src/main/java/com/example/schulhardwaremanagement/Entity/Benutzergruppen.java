package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Benutzergruppen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer benutzergruppenID;
    private String benutzergruppenName;

    @ManyToMany(mappedBy = "benutzergruppen")
    private Set<Benutzer> benutzer;

    public Integer getBenutzergruppenID() {
        return benutzergruppenID;
    }

    public void setBenutzergruppenID(Integer benutzergruppenID) {
        this.benutzergruppenID = benutzergruppenID;
    }

    public String getBenutzergruppenName() {
        return benutzergruppenName;
    }

    public void setBenutzergruppenName(String benutzergruppenName) {
        this.benutzergruppenName = benutzergruppenName;
    }

    public Set<Benutzer> getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(Set<Benutzer> benutzer) {
        this.benutzer = benutzer;
    }
}