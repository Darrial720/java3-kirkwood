package com.shirley.demo.day2.day6;

public class Rectangle extends Shape{
    private double length;
    private double height;
    public Rectangle(int numSides) {
        super(numSides);
        length = 1;
        height = 1;
    }

    @Override
    double getArea() {
        return length * height;
    }
}
