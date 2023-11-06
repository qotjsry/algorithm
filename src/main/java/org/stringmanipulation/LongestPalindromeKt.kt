package org.stringmanipulation

var left: Int = 0
var maxLen: Int = 0

fun longestPalindrome(s: String): String {
    var len = s.length

    if(len < 2) return s

    for(i in 0 until len - 1) {
        extendPalindrome(s, i, i + 1)
        extendPalindrome(s, i, i + 2)
    }

    return s.substring(left, left + maxLen)
}

fun extendPalindrome(s:String, j: Int, k: Int) {
    var l = j;
    var r = k;

    while (l >= 0 && r < s.length && s[l] == s[r]) {
        l--;
        r++;
    }

    if (maxLen < r - l - 1) {
        left = l + 1;
        maxLen = r - l - 1
    }
}

fun main() {
    var testString = "dcbabcdd"

    println(longestPalindrome(testString))
}