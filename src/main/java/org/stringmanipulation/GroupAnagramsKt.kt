package org.stringmanipulation

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    var results: MutableMap<String, MutableList<String>> = mutableMapOf()

    for (value in strs) {
        val key = value.toCharArray().sorted().joinToString("");

        results.getOrPut(key) { mutableListOf() }
        results[key]!!.add(value)
    }

    return ArrayList<List<String>>(results.values)
}

fun main() {
    val testArray = arrayOf("ate", "eat", "tan", "tea", "ant", "cat")

    for (list in groupAnagrams(testArray)) {
        println(list.toString())
    }
}