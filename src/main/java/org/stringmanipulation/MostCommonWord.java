package org.stringmanipulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public static String mostCommonWord(String s, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        String[] words = s.replaceAll("\\W+"," ").toLowerCase().split(" ");

        for (String value : words) {
            System.out.println("value = " + value);
            if (!ban.contains(value)) {
               counts.put(value, counts.getOrDefault(value,0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String testString = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};

        System.out.println("mostCommonWord(testString, banned) = " + mostCommonWord(testString, banned));
    }

}
