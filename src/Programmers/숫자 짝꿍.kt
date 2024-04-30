package Programmers

import java.lang.Integer.min

fun main() {
    println(solution("100", "2345"))
}

fun solution(X: String, Y: String): String {
    var answer: String = ""
    val xCountArray = IntArray(10)
    val yCountArray = IntArray(10)

    X.forEach {
        xCountArray[it.toString().toInt()]++
    }
    Y.forEach {
        yCountArray[it.toString().toInt()]++
    }

    var answerList = mutableListOf<Int>()
    xCountArray.forEachIndexed { index, i ->
        if (xCountArray[index] != 0 && yCountArray[index] != 0) {
            repeat(min(xCountArray[index], yCountArray[index])) {
                answerList.add(index)
            }
        }
    }
    answer = answerList.sortedDescending().joinToString("")
    if (answerList.distinct() == mutableListOf(0)) answer = "0"
    if (answer.isEmpty()) answer = "-1"

    return answer
}