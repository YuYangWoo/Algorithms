package Programmers.level1

class `달리기 경주` {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playersMap = players.withIndex().associate { it.value to it.index }.toMutableMap()

        callings.forEach {
            val ranking = playersMap.getOrDefault(it, 0)
            val frontPlayer = players[ranking - 1]
            players[ranking] = frontPlayer
            players[ranking - 1] = it

            playersMap[frontPlayer] = ranking
            playersMap[it] = ranking - 1

        }
        return players
    }
}

fun main() {
    println(`달리기 경주`().solution(arrayOf("mumu", "soe", "poe", "kai", "mine"), arrayOf("kai", "kai", "mine", "mine")))
}