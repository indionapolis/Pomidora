package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    private String name;
    public void initialize(String name){
        this.name = name;
    }

    private int age;
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
    }
    private char sex;
    public void initialize(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public static void main(String[] args) {

    }
}
