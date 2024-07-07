package Programmers

class `연속 부분 수열 합의 개수` {
    fun solution(elements: IntArray): Int {
        var extendedElements = elements + elements
        val uniqueSet = mutableSetOf<Int>()
        for (i in elements.indices) {
            for (j in elements.indices) {
                uniqueSet.add(extendedElements.slice(j .. j + i).sum())
            }
        }

        return uniqueSet.size
    }
}

fun main() {
    println(`연속 부분 수열 합의 개수`().solution(intArrayOf(7, 9, 1, 1, 4)))
}