package com.codelatte.enumtest;

public enum Gender {
    MALE("male"), FEMALE("female");

    String text;

    Gender(String text) {
        this.text = text;
    }
}