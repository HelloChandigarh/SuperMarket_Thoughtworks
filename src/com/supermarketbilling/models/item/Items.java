package com.supermarketbilling.models.item;

import com.supermarketbilling.models.item.Item;

import java.util.Map;

public class Items {

    private Map<String, Item> items;

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }
}
