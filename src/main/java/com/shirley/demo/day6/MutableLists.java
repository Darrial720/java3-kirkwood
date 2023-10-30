package com.shirley.demo.day6;

import com.shirley.demo.day2.BankAccount;
import java.util.*;

public class MutableLists {
    private static List<BankAccount> myList3;

    public static void main(String[] args) {
        myList3 = new ArrayList<>(Arrays.asList(new BankAccount(100)));
        myList3.add(new BankAccount(200));//add method is abstract if List
        MyCollections.printCollection(myList3, "vertical");
    }
}
