package org.stringmanipulation

fun recorderLogFiles(logs:Array<String>): Array<String> {
    var letterList = mutableListOf<String>()
    var digitList = mutableListOf<String>()

    for (log in logs) {
        if (Character.isDigit(log.split(" ")[1][0])) {
            digitList.add(log)
        } else {
            letterList.add(log)
        }
    }

    letterList.sortWith(Comparator { s1: String, s2: String ->
        val s1Array = s1.split(" ", limit = 2)
        val s2Array = s2.split(" ", limit = 2)

        var compared = s1Array[1].compareTo(s2Array[1])

        if(compared == 0)
            s1Array[0].compareTo(s2Array[0])

        compared
    })

    letterList.addAll(digitList)

    return letterList.toTypedArray()
}

fun main() {
    val logs = arrayOf("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero")

    for (log in recorderLogFiles(logs)) {
        println(log)
    }
}