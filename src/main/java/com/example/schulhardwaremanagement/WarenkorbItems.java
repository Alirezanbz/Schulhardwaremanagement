package com.example.schulhardwaremanagement;

public class WarenkorbItems {
    private Long gegenstandId;

    private String name;
    private int anzahl;

    public Long getGegenstandId() {
        return gegenstandId;
    }

    public void setGegenstandId(Long gegenstandId) {
        this.gegenstandId = gegenstandId;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

