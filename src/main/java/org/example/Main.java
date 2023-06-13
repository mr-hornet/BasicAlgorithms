package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<String> list = new ArrayList<>();
        list.add(0,"sdf");
//        list.set(1, "sdg3eg");
        System.out.println(list);

        StringList stringList = new StringListImpl();
        System.out.println(stringList.add("Good"));
        System.out.println(stringList.add(6, "bad"));


    }

    public static String come() {
        return "come";
    }
}