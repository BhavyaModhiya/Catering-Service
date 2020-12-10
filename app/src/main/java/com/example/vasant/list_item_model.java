package com.example.vasant;

public class list_item_model {

    private String  list_Name, list_qty;

    public list_item_model(String list_Name) {
        this.list_Name = list_Name;

    }

    public String getList_Name() {
        return list_Name;
    }

    public void setList_Name(String list_Name) {
        this.list_Name = list_Name;
    }

    public String getList_qty() {
        return list_qty;
    }

    public void setList_qty(String list_qty) {
        this.list_qty = list_qty;
    }
}
