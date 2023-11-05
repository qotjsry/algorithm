package org.stringmanipulation;

import java.util.ArrayList;
import java.util.List;

public class RecorderLogFiles {

    public static String[] recorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
               digitList.add(log);
            } else {
                letterList.add(log);
            }
        }
        letterList.sort((s1, s2) -> {
            String[] s1Array = s1.split(" ", 2);
            String[] s2Array = s2.split(" ", 2);

            int compared = s1Array[1].compareTo(s2Array[1]);
            if (compared == 0) {
                return s1Array[0].compareTo(s2Array[0]);
            }
            return compared;
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] logs = {"id1 8 1 5 1","id2 art can","id3 3 6","id4 own kit dig","id5 art zero"};

        for (String log : recorderLogFiles(logs)) {
            System.out.println("log = " + log);
        }
    }

}
