package com.example.smartmonthly;

public class HomeDrawer {

     String ItemName;

     public HomeDrawer(String itemName) {
           super();
           ItemName = itemName;
     }
    

     public String getItemName() {
           return ItemName;
     }
     public void setItemName(String itemName) {
           ItemName = itemName;
     }
}