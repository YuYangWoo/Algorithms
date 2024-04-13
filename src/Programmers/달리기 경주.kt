package Programmers

fun main() {
    val solution = Solution()
    println(solution.solution(arrayOf("mumu", "soe", "poe", "kai", "mine"), arrayOf("kai", "kai", "mine", "mine")))
}

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val map = HashMap<String, Int>()
        for (i in players.indices) {
            map[players[i]] = i
        }

        callings.forEach {
            val callRank = map[it] ?: 0 // 3
            val frontPlayer = players[callRank - 1] // poe
            players[callRank] = frontPlayer
            players[callRank - 1] = it

            map[it] = callRank - 1
            map[frontPlayer] = callRank
        }

        return answer
    }
}