package org.stringmanipulation

fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val counts: MutableMap<String, Int> = mutableMapOf()
    val words = paragraph.replace("\\W+".toRegex(), " ").toLowerCase().split(" ")

    for (w in words) {
        if (!banned.contains(w)) {
            counts[w] = counts.getOrDefault(w, 0) + 1
        }
    }

    return counts.maxByOrNull { it.value }!!.key
}

fun main() {
    val testString = "Ross hit a ball, the hit BALL flew far away after it was hit."
    val banned = arrayOf("hit")

    println(mostCommonWord(testString, banned))
}