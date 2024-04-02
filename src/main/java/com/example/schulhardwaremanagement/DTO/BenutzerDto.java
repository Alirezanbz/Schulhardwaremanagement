package com.example.schulhardwaremanagement.DTO;

public class BenutzerDto {
    private String vorname;
    private String name;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BenutzerDto(String vorname, String name) {
        this.vorname = vorname;
        this.name = name;
    }
}
