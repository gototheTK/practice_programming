package com.codelatte.enumtest;

public enum FoodCategory {
    BREAD("빵"),
      CAKE(17000, "케이크"),
      COFFEE(4300, "커피"),
      BEVERAGE(2500, "음료");
      
    int price;
    String name;
    
    FoodCategory(int price, String name) {
        this.price = price;
        this.name = name;
    }
    
    FoodCategory(String name) {
        this.name = name;
    }
    
}