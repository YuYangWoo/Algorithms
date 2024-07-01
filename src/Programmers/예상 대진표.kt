package Programmers

class `예상 대진표` {
    fun solution(n: Int, a: Int, b: Int): Int {
        var user1 = a
        var user2 = b
        var round = 0
        while (user1 != user2) {
            user1 = (user1 + 1) / 2
            user2 = (user2 + 1) / 2
            round++
        }
        return round
    }
}

fun main() {
    println(`예상 대진표`().solution(16, 9, 12))
}