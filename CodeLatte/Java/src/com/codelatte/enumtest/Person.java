package com.codelatte.enumtest;

public class Person {

    public void eat(FoodCategory foodCategory) {
        switch (foodCategory) {
            case BREAD:
                System.out.println("빵");
                break;
            case CAKE:
                System.out.println("케이크");
                break;
            case COFFEE:
                System.out.println("커피");
                break;
            case BEVERAGE:
                System.out.println("음료");
                break;
        }
    }
}