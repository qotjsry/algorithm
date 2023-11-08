package org.array

fun trap(height:IntArray): Int {
    var volume = 0
    var left = 0
    var right = height.size - 1
    var leftMax = height[left]
    var rightMax = height[right]

    while (left < right) {
        leftMax = height[left].coerceAtLeast(leftMax)
        rightMax = height[right].coerceAtLeast(rightMax)

        if (leftMax <= rightMax) {
            volume += leftMax - height[left]
            left += 1
        } else {
            volume += rightMax - height[right]
            right -= 1
        }
    }
    return volume
}

fun  main() {
    val heights = intArrayOf(1,1,0,2,1,0,1,3,2,1,2,1)

    println(trap(heights))
}