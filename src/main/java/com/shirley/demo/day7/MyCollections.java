package com.shirley.demo.day7;

import com.shirley.demo.day2.Person;

import java.util.*;

public class MyCollections {
    public static void main(String[] args){
        List<String> programmingLanguages = new ArrayList<>(Arrays.asList("Python", "C#", "Java", "PHP", "Cobol"));
        List<String> copy = new ArrayList<>(programmingLanguages);
        /*Set<String> copy1 = new HashSet<>();
        copy1.forEach(System.out::println);
        Map<String, String> copy2 = new HashMap<>();
        copy2.forEach(System.out::println);*/

        copy.removeIf((language) -> language.toLowerCase().charAt(0) != 'p');
        copy.forEach(System.out::println);
        System.out.println();
        programmingLanguages.forEach(System.out::println);

        List<Person> people = new ArrayList<>(){{
            add(new Person("Python"));
            add(new Person("C#"));
            add(new Person("Java"));
            add(new Person("PHP"));
            add(new Person("Cobol"));
        }};
        List<Person> copy2 = new ArrayList<>(people);

        copy2.removeIf((Person) -> Person.getName().toLowerCase().charAt(0) != 'p');
        copy2.forEach(System.out::println);
        System.out.println();
        people.forEach(System.out::println);
    }

}
