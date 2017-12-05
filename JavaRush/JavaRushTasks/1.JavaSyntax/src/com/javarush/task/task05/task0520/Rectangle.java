package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


import com.sun.org.apache.regexp.internal.RE;

public class Rectangle {
    int top, left, width, height;

    public Rectangle(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int top){
        this.top = top;
        this.left = 0;
        this.width = top;
        this.height = 0;
    }

    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
        this.width = left;
        this.height = 0;
    }

    public Rectangle(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = 0;
    }

    public static void main(String[] args) {

    }
}
