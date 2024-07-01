package Programmers

class `귤 고르기` {
    fun solution(k: Int, tangerine: IntArray): Int {
        var count = 0
        var answer = 0
        tangerine.groupBy { it }
            .toList()
            .sortedByDescending { it.second.size }
            .toMap()
            .toMutableMap()
            .forEach { entry ->
                if (count >= k) return@forEach
                count += entry.value.size
                answer++
            }

        return answer
    }

}

fun main() {
    println(`귤 고르기`().solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)))
}