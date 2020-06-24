package com.example.oishi.food_menu;

public class FoodMenuListViewItem {
    //가게의 부모 메뉴(메뉴판 카테고리) 이미지
    private String Parents_Img;
    //가게의 부모 메뉴(메뉴판 카테고리) 이름
    private String Parents_Name;
    //가게의 부모 메뉴(메뉴판 카테고리) 설명
    private String Parents_Content;

    /*
     ListView에 사용되는 대표메뉴 이미지, 이름, 설명에 gettet를 추가하여
     하나의 가게 데이터에서 값을 불러올수있게 사용됨
     */

    public String getParents_Img() {
        return Parents_Img;
    }

    public void setParents_Img(String parents_Img) {
        Parents_Img = parents_Img;
    }

    public String getParents_Name() {
        return Parents_Name;
    }

    public void setParents_Name(String parents_Name) {
        Parents_Name = parents_Name;
    }

    public String getParents_Content() {
        return Parents_Content;
    }

    public void setParents_Content(String parents_Content) {
        Parents_Content = parents_Content;
    }
}