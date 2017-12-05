package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Circle(double x, double y){
        this.x = x;
        this.y = y;
        this.radius = 1;
    }


    public Circle(double y){
        this.x = 1;
        this.y = y;
        this.radius = 1;
    }

    public Circle(){
        this.x = 1;
        this.y = 1;
        this.radius = 1;
    }

    public static void main(String[] args) {

    }
}