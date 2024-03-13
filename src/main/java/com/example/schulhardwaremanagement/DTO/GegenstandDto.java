package com.example.schulhardwaremanagement.DTO;

public class GegenstandDto {
    private String detailsName;
    private String beschreibung;
    private String bildpfad;
    private String lagerortName;
    private String gebaeudeName;
    private String status;

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

    public String getLagerortName() {
        return lagerortName;
    }

    public void setLagerortName(String lagerortName) {
        this.lagerortName = lagerortName;
    }

    public String getGebaeudeName() {
        return gebaeudeName;
    }

    public void setGebaeudeName(String gebaeudeName) {
        this.gebaeudeName = gebaeudeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

