package com.example.oishi.detail_menu.model;

public class ChildItem extends Item {
    public String price;

    public ChildItem(String name, int viewType, String price){
        this.name = name;
        this.viewType = viewType;
        this.price = price;
    }
}
