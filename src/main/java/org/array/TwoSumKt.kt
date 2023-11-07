package org.array

import java.util.*

fun twoSum(nums:IntArray, target:Int): IntArray {
    val numsMap: MutableMap<Int, Int> = mutableMapOf()

    for ((i, num) in nums.withIndex()) {
        if(numsMap.containsKey(target - num)) {
            return intArrayOf(numsMap[target - num] ?: 0, i)
        }
        numsMap[num] = i
    }
    return intArrayOf(0, 0)
}

fun main() {
    val nums = intArrayOf(2, 6, 11, 15)
    val target = 8

    println(twoSum(nums, target).contentToString())
}