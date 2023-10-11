package com.shirley;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class QuizSix {
    private static List<Integer> testScores;
    private static Map<String, Integer> groceryList;

    public static void main(String[] args) {
        //testScores = new ArrayList<>(Arrays.asList(85, 98));
        //testScores.add(0, 77);
        //testScores.forEach(System.out::println);
        //testScores.forEach(Integer -> System.out.println(Integer));
        Map<String, Integer> groceryList = new HashMap<>();
        groceryList.put("milk", 1);
        groceryList.put("bread", 2);
        groceryList.put("eggs", 1);

        String[] strings = {"a", "bb", "a", "bb"};
        int two= strings.length;
        String word = "words";
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(6);
        set.add(5);
        set.add(100);
        ArrayList<Integer> nums = new ArrayList<>();
        nums = new ArrayList<>(set);
        nums.sort(null);

        System.out.println(nums);

        //for(int i = 0; i < groceryList.size(); i++){
        //    System.out.println(groceryList.get(i) + "=" + i);
        //}





    }
}
