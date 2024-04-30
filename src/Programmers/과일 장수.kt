package Programmers

fun main() {
    println(solution1(4, 5, intArrayOf(1, 2, 3, 1, 2, 3, 1)))
}

fun solution1(k: Int, m: Int, score: IntArray): Int {
    var answer: Int = 0
    val list = score.sortedDescending()
    var startIndex = 0
    var index = m
    while (true) {
        if (index > score.size) break
        answer += list.subList(startIndex, index).minOf { it } * m
        startIndex += m
        index += m
    }
    return answer
}

