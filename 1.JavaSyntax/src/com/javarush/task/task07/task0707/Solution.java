package com.javarush.task.task07.task0707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();


        list.add("dfhd");
        list.add("dfhd");
        list.add("dfhd");
        list.add("dfhd");
        list.add("dfhd");
        System.out.println(list.size());
        for(int i = 0; i < 5; i++){
            System.out.println(list.get(i));
        }
    }
}
