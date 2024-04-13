package Programmers

fun main() {
//    println(solution(8, 4, intArrayOf(2, 3, 6)))
//    println(solution(8, 4, intArrayOf(2, 3, 6)))
    println(solution(4, 1, intArrayOf(1,2,3,4)))
}

fun solution(n: Int, m: Int, section: IntArray): Int {
    var answer: Int = 0
    val array = BooleanArray(n).apply {
        section.forEach {
            this[it - 1] = true
        }
    }
    array.forEachIndexed { index, item ->
        if (item) {
            var i = index
            repeat(m) {
                if (i < array.size)
                array[i++] = false
            }
            answer ++
        }
    }
    return answer
}