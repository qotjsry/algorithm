package org.stringmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

        for (String value : strs) {
            char[] chars = value.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);

            if (!results.containsKey(key)) {
               results.put(key,new ArrayList<>());
            }
            results.get(key).add(value);
        }

        return new ArrayList<>(results.values());
    }

    public static void main(String[] args) {
        String[] testArray = {"ate","eat","tan","tea","ant","cat"};

        for (List<String> list : groupAnagrams(testArray)) {
            System.out.println("list.toString() = " + list.toString());
        }
    }

}
