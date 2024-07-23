package Programmers.level1

class `햄버거 만들기` {

    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val sb = StringBuilder()
        ingredient.forEach {
            sb.append(it)

            if (sb.length >= 4 && sb.substring(sb.length - 4, sb.length) == "1231") {
                answer++
                sb.replace(sb.length - 4, sb.length, "")
            }
        }
        return answer
    }

}

fun main() {
    println(`햄버거 만들기`().solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))
}