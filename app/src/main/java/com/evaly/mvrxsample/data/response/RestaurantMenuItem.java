package com.evaly.mvrxsample.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestaurantMenuItem {

    @SerializedName("cuisine_name")
    private String cuisineName;

    @SerializedName("items")
    private List<FoodItem> items;

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return
                "RestaurantMenuItem{" +
                        "cuisine_name = '" + cuisineName + '\'' +
                        ",items = '" + items + '\'' +
                        "}";
    }
}