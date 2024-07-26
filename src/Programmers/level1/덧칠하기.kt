package Programmers.level1

import kotlin.math.min

class 덧칠하기 {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val paints = IntArray(n) {1}
        section.forEach {
            paints[it-1] = 0
        }
        for (i in paints.indices) {
            if (paints[i] == 0) {
                val targetIndex = i + m
                for (j in i until min(targetIndex, paints.size)) {
                    paints[j] = 1
                }
                answer++
            }
        }
        return answer
    }
}

fun main() {
    println(덧칠하기().solution(8, 4, intArrayOf(2,3,6)))
//    println(덧칠하기().solution(4, 1, intArrayOf(1,2,3,4)))
}