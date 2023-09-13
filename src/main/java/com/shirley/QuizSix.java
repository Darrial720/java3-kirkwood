package com.shirley;

import java.util.ArrayList;
import java.util.Arrays;


import java.util.Iterator;
import java.util.List;

public class QuizSix {
    private static List<Integer> testScores;
    private static List<String> groceryList;

    public static void main(String[] args) {
        //testScores = new ArrayList<>(Arrays.asList(85, 98));
        //testScores.add(0, 77);
        //testScores.forEach(System.out::println);
        //testScores.forEach(Integer -> System.out.println(Integer));
        groceryList = new ArrayList<String>();
        groceryList.add("milk");
        groceryList.add("bread");
        groceryList.add("bread");
        groceryList.add("eggs");
        groceryList.add("bread");


        for(String str : groceryList){
            if(str.equals("bread")){
                groceryList.remove(str);
            }
        }
        groceryList.forEach(String -> System.out.println(String));
        //System.out.println(testScores);// your code here
    }
}
