package org.stringmanipulation

fun reverseString(s: CharArray): CharArray {
    var start = 0
    var end = s.size - 1

    while (start < end) {
        s[start] = s[end].also { s[end] = s[start]}

        start++
        end--
    }

    return s;
}

fun main() {
    var testCharArray = charArrayOf('t','e','s','t')

    for(c in reverseString(testCharArray)) {
        println(c)
    }
}