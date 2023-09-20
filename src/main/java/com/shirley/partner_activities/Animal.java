package com.shirley.partner_activities;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }
}

class Rabbit extends Animal{
    public Rabbit(String name) {
        super(name);
    }
}

class Turtle extends Animal{
    public Turtle(String name) {
        super(name);
    }
}