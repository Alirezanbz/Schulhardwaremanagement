package com.example.schulhardwaremanagement;
import com.example.schulhardwaremanagement.DTO.BenutzerDto;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb {
    private List<WarenkorbItems> items = new ArrayList<>();

    private BenutzerDto verleiher;

    public List<WarenkorbItems> getItems() {
        return items;
    }

    public void addItem(WarenkorbItems item) {
        this.items.add(item);
    }

    public void removeItem(WarenkorbItems item) {
        this.items.remove(item);
    }



    public BenutzerDto getVerleiher() {
        return verleiher;
    }

    public void setVerleiher(BenutzerDto verleiher) {
        this.verleiher = verleiher;
    }

}
