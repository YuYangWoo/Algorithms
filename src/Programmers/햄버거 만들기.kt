package Programmers

fun main() {
    println(solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
}

fun solution(ingredient: IntArray): Int {
    var answer: Int = 0
    val recipe = "1231"

    val sb = StringBuilder()
    ingredient.forEach {
        sb.append(it)
        if (sb.length >= 4 && sb.substring(sb.length - 4) == recipe) {
            sb.setLength(sb.length - 4)
            answer++
        }
    }

    return answer
}