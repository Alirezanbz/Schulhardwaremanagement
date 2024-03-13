package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.*;



@Entity
public class Gegenstand {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer gegenstandsID;
    private String status;

    @ManyToOne
    @JoinColumn(name = "gegenstandDetailsID", referencedColumnName = "gegenstandDetailsID")
    private GegenstandsDetail gegenstandsDetail;

    @ManyToOne
    @JoinColumn(name = "lagerortID", referencedColumnName = "lagerortID")
    private Lagerort lagerort;

    public Integer getGegenstandsID() {
        return gegenstandsID;
    }

    public void setGegenstandsID(Integer gegenstandsID) {
        this.gegenstandsID = gegenstandsID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GegenstandsDetail getGegenstandsDetail() {
        return gegenstandsDetail;
    }

    public void setGegenstandsDetail(GegenstandsDetail gegenstandsDetail) {
        this.gegenstandsDetail = gegenstandsDetail;
    }

    public Lagerort getLagerort() {
        return lagerort;
    }

    public void setLagerort(Lagerort lagerort) {
        this.lagerort = lagerort;
    }
}