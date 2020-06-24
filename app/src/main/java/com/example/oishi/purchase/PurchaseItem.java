package com.example.oishi.purchase;

public class PurchaseItem {
    private String name;
    private String count;
    private String price;
    private int totalsum;

    public PurchaseItem(String id, String price, String count) {
        this.name = id;
        this.price = price;
        this.count = count;
    }

    public String getCount() {
        return this.count;
    }


    public String getPrice() {
        return this.price;
    }

    public String getname() {
        return this.name;
    }

    public void setCount(String rating) {
        this.count = rating;
    }

    public void setPrice(String time) {
        this.price = time;
    }

    public void setName(String id) {
        this.name = id;
    }

}
