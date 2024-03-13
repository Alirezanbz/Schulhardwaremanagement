package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Ausleihauftrag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ausleihauftragID;

    @ManyToOne
    @JoinColumn(name = "ausleiherID", referencedColumnName = "benutzerID")
    private Benutzer ausleiher;

    @ManyToOne
    @JoinColumn(name = "verleiherID", referencedColumnName = "benutzerID")
    private Benutzer verleiher;

    @ManyToOne
    @JoinColumn(name = "gegenstandsID", referencedColumnName = "gegenstandsID")
    private Gegenstand gegenstand;

    private Date datumAusgabe;
    private Date datumRueckgabe;
    private Integer datumFrist;


    public Integer getAusleihauftragID() {
        return ausleihauftragID;
    }

    public void setAusleihauftragID(Integer ausleihauftragID) {
        this.ausleihauftragID = ausleihauftragID;
    }

    public Benutzer getAusleiher() {
        return ausleiher;
    }

    public void setAusleiher(Benutzer ausleiher) {
        this.ausleiher = ausleiher;
    }

    public Benutzer getVerleiher() {
        return verleiher;
    }

    public void setVerleiher(Benutzer verleiher) {
        this.verleiher = verleiher;
    }

    public Gegenstand getGegenstand() {
        return gegenstand;
    }

    public void setGegenstand(Gegenstand gegenstand) {
        this.gegenstand = gegenstand;
    }

    public Date getDatumAusgabe() {
        return datumAusgabe;
    }

    public void setDatumAusgabe(Date datumAusgabe) {
        this.datumAusgabe = datumAusgabe;
    }

    public Date getDatumRueckgabe() {
        return datumRueckgabe;
    }

    public void setDatumRueckgabe(Date datumRueckgabe) {
        this.datumRueckgabe = datumRueckgabe;
    }

    public Integer getDatumFrist() {
        return datumFrist;
    }

    public void setDatumFrist(Integer datumFrist) {
        this.datumFrist = datumFrist;
    }
}
