package com.pantry_prototype.prototype1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Items {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ItemId;
    
    @Column
    private String ItemName;

    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    @Override
    public String toString() {
        return "Items [ItemId=" + ItemId + ", ItemName=" + ItemName + "]";
    }
}
