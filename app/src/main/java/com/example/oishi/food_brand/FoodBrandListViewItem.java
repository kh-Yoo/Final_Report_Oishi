package com.example.oishi.food_brand;

public class FoodBrandListViewItem {
    //가게 이름
    private String Main_Store_Name;
    //가게 전화번호
    private String Main_Store_Phone_Number;
    //가게 이미지
    private String Main_Store_Icon;
    //가게 대표 메뉴
    private String Main_Store_menu;
    //가게 찜한 가게
    private int Main_Store_Favorite;
    //가게 최소 주문 가게
    private int Main_Store_Min_Price;
    //가게 배달 시간
    private String Main_Store_Delivery_Time;
    //가게 배달 팁
    private int Main_Store_Delivery_Tip;
    //가게 주문 수
    private int Main_Store_Order_Number;
    //가게 운영시간
    private String Main_Store_Running_Time;
    //가게 휴무일
    private String Main_Store_Holiday;
    //가게 주소
    private String Main_Store_Detail_Address;
    //가게 별점
    private float Main_Store_Rating;
    //가게 리뷰
    private int Main_Store_Review;

    /*
     ListView에 사용되는 브랜드 이미지, 이름, 전화번호, 대표메뉴는 getter and setter를 사용하였고
     나머지 속성들은 getter를 사용하여 하나의 가게 데이터에서 값을 불러올수있게 사용됨
     */

    public String getMain_Store_Name() {
        return Main_Store_Name;
    }

    public void setMain_Store_Name(String main_Store_Name) {
        Main_Store_Name = main_Store_Name;
    }

    public String getMain_Store_Phone_Number() {
        return Main_Store_Phone_Number;
    }

    public void setMain_Store_Phone_Number(String main_Store_Phone_Number) {
        Main_Store_Phone_Number = main_Store_Phone_Number;
    }

    public String getMain_Store_Icon() {
        return Main_Store_Icon;
    }

    public void setMain_Store_Icon(String main_Store_Icon) {
        Main_Store_Icon = main_Store_Icon;
    }

    public String getMain_Store_menu() {
        return Main_Store_menu;
    }

    public void setMain_Store_menu(String main_Store_menu) {
        Main_Store_menu = main_Store_menu;
    }

    public int getMain_Store_Favorite() {
        return Main_Store_Favorite;
    }

    public int getMain_Store_Min_Price() {
        return Main_Store_Min_Price;
    }

    public String getMain_Store_Delivery_Time() {
        return Main_Store_Delivery_Time;
    }

    public int getMain_Store_Delivery_Tip() {
        return Main_Store_Delivery_Tip;
    }

    public int getMain_Store_Order_Number() {
        return Main_Store_Order_Number;
    }

    public String getMain_Store_Running_Time() {
        return Main_Store_Running_Time;
    }

    public String getMain_Store_Holiday() {
        return Main_Store_Holiday;
    }

    public String getMain_Store_Detail_Address() {
        return Main_Store_Detail_Address;
    }

    public float getMain_Store_Rating() {
        return Main_Store_Rating;
    }

    public int getMain_Store_Review() {
        return Main_Store_Review;
    }
}