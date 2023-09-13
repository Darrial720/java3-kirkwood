package com.shirley.day6;

public class Circle extends Shape {

    private double radius;
    public Circle(int numSides) {
        super(numSides);
        radius = 1;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}
