package com.example.oishi.menu_sort;

public class MenuSortItem {
    //정렬 리스트의 이름
    private String name;
    //정렬 리스트의 view_Type
    private int viewType;

    //정렬 리스트 생성자
    public MenuSortItem(String name, int viewType) {
        this.name = name;
        this.viewType = viewType;
    }

    public String getName() {
        return name;
    }

    public int getViewType() {
        return viewType;
    }
}
