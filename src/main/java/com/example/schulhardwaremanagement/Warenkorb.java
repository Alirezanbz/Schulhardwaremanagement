package com.example.schulhardwaremanagement;
import java.util.ArrayList;
import java.util.List;

public class Warenkorb {
    private List<WarenkorbItems> items = new ArrayList<>();

    public List<WarenkorbItems> getItems() {
        return items;
    }

    public void addItem(WarenkorbItems item) {
        this.items.add(item);
    }

    public void removeItem(WarenkorbItems item) {
        this.items.remove(item);
    }

}
