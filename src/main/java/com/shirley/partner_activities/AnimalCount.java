package com.shirley.partner_activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalCount {
    public static void main(String[] args){
        Map<Person, List<Animal>> owners_and_their_pets = new HashMap<>();

        Person marc = new Person("Marc");
        List<Animal> marcs_pets = new ArrayList<>() {{
            add(new Cat("Waffles"));
            add(new Cat("Sprout"));
        }};
        owners_and_their_pets.put(marc, marcs_pets);

        Person krystal = new Person("Krystal");
        List<Animal> krystal_pets = new ArrayList<>() {{
            add(new Cat("Todd"));
            add(new Cat("Margo"));
            add(new Dog("Gus"));
        }};
        owners_and_their_pets.put(krystal, krystal_pets);

        Person bob = new Person("Bob");
        List<Animal> bobs_pets = new ArrayList<>();
        owners_and_their_pets.put(bob, bobs_pets);

        Person amy = new Person("Amy");
        List<Animal> amys_pets = new ArrayList<>();
        amys_pets.add(new Cat("Zipper"));
        owners_and_their_pets.put(amy, amys_pets);

        Person Darryl = new Person("Darryl");
        List<Animal> darryls_pets = new ArrayList<>() {{
            add(new Turtle("Michaelangelo"));
            add(new Dog("Aech"));
            add(new Dog("Coco"));
        }};
        owners_and_their_pets.put(Darryl, darryls_pets);

        Person mohmed = new Person("Mohmed");
        List<Animal> mohmed_pets = new ArrayList<>();
        mohmed_pets.add(new Rabbit("kiki"));
        owners_and_their_pets.put(mohmed, mohmed_pets);


        owners_and_their_pets.forEach((person, animals) -> {
            if (animals.size() == 0) {
                System.out.println(person + " has no pets.");
            } else if (animals.size() == 1) {
                System.out.println(person + "'s pet: " + animals.stream().map(Object::toString).collect(Collectors.joining(", ")));
            } else if (animals.size() > 1) {
                System.out.println(person + "'s pets: " + animals.stream().map(Object::toString).collect(Collectors.joining(", ")));
            }
        });

        System.out.println();
        Map<String, Integer> counter = new HashMap<>();

        for(Person person: owners_and_their_pets.keySet()){
            List<Animal> animals = owners_and_their_pets.get(person);
            animals.forEach(el -> {
                String type = el.getClass().getSimpleName();
                if (counter.containsKey(type)) {
                    counter.put(type, counter.get(type) + 1);
                } else {
                    counter.put(type, 1);
                }
            });

        }

        counter.forEach((type, count) -> {
            if (count == 1) {
                        System.out.println("There is " + count + " " + type);
            } else if (count > 1) {
                        System.out.println("There are " + count + " " + type + "'s");
            }
        });

    }
}

