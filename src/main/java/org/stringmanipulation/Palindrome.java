package org.stringmanipulation;

public class Palindrome {

    public static boolean isPalindrome_1(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static boolean isPalindrome_2(String s) {
        String s_filter = s.replace("[^A-Za-z0-9]","").toLowerCase();
        String s_result = new StringBuffer(s_filter).reverse().toString();

        return s_filter.equals(s_result);
    }

    public static void main(String[] args) {
        String successString = "abcdcba";
        String faultString = "abcdas";

        System.out.println("isPalindrome_1 = " + isPalindrome_1(successString));
        System.out.println("isPalindrome_2 = " + isPalindrome_2(successString));
        System.out.println("isPalindrome_1 = " + isPalindrome_1(faultString));
        System.out.println("isPalindrome_2 = " + isPalindrome_2(faultString));
    }
}
