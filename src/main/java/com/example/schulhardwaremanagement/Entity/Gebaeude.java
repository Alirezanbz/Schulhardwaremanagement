package com.example.schulhardwaremanagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gebaeude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gebaeudeID;
    private String gebaeudeName;

    public Integer getGebaeudeID() {
        return gebaeudeID;
    }

    public void setGebaeudeID(Integer gebaeudeID) {
        this.gebaeudeID = gebaeudeID;
    }

    public String getGebaeudeName() {
        return gebaeudeName;
    }

    public void setGebaeudeName(String gebaeudeName) {
        this.gebaeudeName = gebaeudeName;
    }
}
