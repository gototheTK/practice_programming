package com.codelatte.enumtest;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enum 예제 1");

        // TODO : enum 예제 1
        System.out.println("FoodCategory.BEVERAGE.ordinal() : "+FoodCategory.BEVERAGE.ordinal());
        System.out.println("FoodCategory.BEVERAGE.name() : "+FoodCategory.BEVERAGE.name());
        System.out.println("FoodCategory.BREAD.price : "+FoodCategory.BREAD.name);
        System.out.println("FoodCategory.BEVERAGE.name : "+FoodCategory.BEVERAGE.name);
        
        System.out.println("FoodCategory.BEVERAGE.ordinal() : "+FoodCategory.BEVERAGE.ordinal());
        System.out.println("FoodCategory.BEVERAGE.name() : "+FoodCategory.BEVERAGE.name());

        Person person = new Person();
        person.eat(FoodCategory.BREAD);

        System.out.println("");
        System.out.println("Enum 예제 2");

        // TODO : enum 예제 2
        System.out.println("Gender.FEMALE.ordinal() : "+ Gender.FEMALE.ordinal());
        System.out.println("Gender.FEMALE.name() : "+ Gender.FEMALE.name());
        System.out.println("Gender.FEMALE.text : "+ Gender.FEMALE.text);

    }
}
