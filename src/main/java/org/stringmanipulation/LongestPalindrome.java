package org.stringmanipulation;

public class LongestPalindrome {
    static int left, maxLen;

    public static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
           left = j + 1;
           maxLen = k - j - 1;
        }
    }

    public static String longestPalindrome(String s) {
        int len = s.length();

        if(len < 2) return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(left, left+maxLen);
    }

    public static void main(String[] args) {
        String testString = "dcbabcdd";

        System.out.println("longestPalindrome(testString) = " + longestPalindrome(testString));
    }

}
