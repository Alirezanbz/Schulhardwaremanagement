package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.*;

@Entity
public class Lagerort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lagerortID;
    private String lagerortName;

    @ManyToOne
    @JoinColumn(name = "gebaeudeID", referencedColumnName = "gebaeudeID")
    private Gebaeude gebaeude;

    public Integer getLagerortID() {
        return lagerortID;
    }

    public void setLagerortID(Integer lagerortID) {
        this.lagerortID = lagerortID;
    }

    public String getLagerortName() {
        return lagerortName;
    }

    public void setLagerortName(String lagerortName) {
        this.lagerortName = lagerortName;
    }

    public Gebaeude getGebaeude() {
        return gebaeude;
    }

    public void setGebaeude(Gebaeude gebaeude) {
        this.gebaeude = gebaeude;
    }
}
