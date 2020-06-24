package com.example.oishi.detail_menu.model;

import java.util.ArrayList;

public class ParentItem extends Item {
    public boolean visibilityOfChildItems = true;
    public ArrayList<ChildItem> unvisibleChildItems = new ArrayList<>();

    public ParentItem(String name, int viewType){
        this.name = name;
        this.viewType = viewType;
    }
}
