package com.shirley.day6;
import com.shirley.day2.BankAccount;

import java.util.*;
import java.util.stream.Collectors;

public class MyCollections {
    public static void main(String[] args){
        List<String> myList = new ArrayList<>();/*Assigning the arraylist to the interface object*/
//        List<String> myList = new LinkedList<>();
//        List<String> myList = new Vector<>();

        myList.add("cat");
        myList.add("dog");
        myList.add(1, "rabbit");
        myList.addAll(Arrays.asList("Cat", "Rabbit", "Dog"));//puts the collection at the end of the list
        myList.addAll(3, Arrays.asList("CAT", "RABBIT", "DOG"));// starts the collection at the chosen index of 3
        printCollection(myList, "horizontal");

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(100));
        accounts.add(new BankAccount(200));
        accounts.add(new BankAccount(300));
        accounts.add(new BankAccount(400));
        printCollection(accounts, "vertical");

        Queue<Integer> queue1 = new PriorityQueue<>();

        Set<Double> set1 = new HashSet<>();
//        Set<Double> set2 = new LinkedHashSet<>();
//        Set<Double> set3 = new TreeSet<>();

        Map<String, Integer> map1 = new HashMap<>();
//        Map<String, Integer> map1 = new TreeMap<>();
//        Map<String, Integer> map1 = new Hashtable<>();

        Shape shape = new Circle(1);
        Shape shape2 = new Rectangle(4);

    }

    public static void printCollection(Collection<?> collection, String direction){
        if(direction.equalsIgnoreCase("vertical")) {
            //advanced for loop (aka for-each loop)
//            for(var el: collection){//el stands for element
//                System.out.println(el);
//            }

            // Use the .forEach() method from the Collection class with a lambda expression
//            collection.forEach((el) -> System.out.println(el));

            // Use the .forEach() method from the Collection class with a method reference
            collection.forEach(System.out::println);

        } else{
//            System.out.println(collection);
            // Doesn't print brackets, but prints a comma at the end
//            for(var el: collection) {
//                System.out.print(el + ", ");
//            }
//            System.out.println();

            //Use streams to not print brackets
            System.out.println(collection.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
    }

}

