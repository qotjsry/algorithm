package org.stringmanipulation;

import ch.qos.logback.core.spi.PreSerializationTransformer;

public class ReverseString {

    public static char[] reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        return s;
    }

    public static void main(String[] args) {
        char[] testCharArray = {'t', 'e', 's', 't'};
        for (char c : reverseString(testCharArray)) {
            System.out.println("c = " + c);
        }
    }

}
