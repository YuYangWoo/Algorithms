package Programmers.level1

import kotlin.math.min

class 과일장수 {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        score.sortDescending()
        var start = 0
        var end = m
        repeat(score.size / m) {
            score.slice(start until end).also {
                answer += (it.min() * it.size)
            }
            start += m
            end = min(end + m, score.size)
        }
        return answer
    }
}

fun main() {
    println(과일장수().solution(4,3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)))
}