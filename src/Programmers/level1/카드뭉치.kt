package Programmers.level1

class 카드뭉치 {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val cardList1 = cards1.toMutableList()
        val cardList2 = cards2.toMutableList()
        var answer: String = ""
        goal.forEach {
            if (cardList1.firstOrNull() == it) {
                answer += it
                cardList1.removeFirstOrNull()
            } else if (cardList2.firstOrNull() == it) {
                answer += it
                cardList2.removeFirstOrNull()
            }
        }
        answer = if (answer == goal.joinToString("")) "Yes" else "No"
        return answer
    }
}

fun main() {
    println(카드뭉치().solution(arrayOf("i", "water", "drink"), arrayOf("want", "to"), arrayOf("i", "want", "to", "drink", "water")))
}