package com.shirley.day6;

import com.shirley.day2.BankAccount;
import java.util.*;

import static com.shirley.day6.MyCollections.printCollection;

public class MutableLists {
    private static List<BankAccount> myList3;

    public static void main(String[] args) {
        myList3 = new ArrayList<>(Arrays.asList(new BankAccount(100)));
        myList3.add(new BankAccount(200));//add method is abstract if List
        printCollection(myList3, "vertical");
    }
}
