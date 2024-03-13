package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GegenstandsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gegenstandDetailsID;
    private String detailsName;
    private String beschreibung;
    private String bildpfad;

    public Integer getGegenstandDetailsID() {
        return gegenstandDetailsID;
    }

    public void setGegenstandDetailsID(Integer gegenstandDetailsID) {
        this.gegenstandDetailsID = gegenstandDetailsID;
    }

    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBildpfad() {
        return bildpfad;
    }

    public void setBildpfad(String bildpfad) {
        this.bildpfad = bildpfad;
    }
}