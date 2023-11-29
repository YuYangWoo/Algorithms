fun solution(food: IntArray): String {
    var answer: String = ""

    food.mapIndexed { index, item ->
        repeat(item / 2) {
            answer += index
        }
    }
    val reverse = answer.reversed()
    answer += "0"
    answer += reverse
    return answer
}

fun main() {
    solution(intArrayOf(1, 7, 1, 2))
}