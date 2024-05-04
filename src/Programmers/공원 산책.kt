package Programmers

fun main() {
    solution(arrayOf("OSO","OOO","OXO","OOO"), arrayOf("E 2","S 3","W 1")).forEach {
        println(it)
    }
}

private val dir = hashMapOf(
    "E" to  (0 to 1), // 동
    "W" to (0 to -1), // 서
    "S" to (1 to 0), // 남
    "N" to (-1 to 0) // 북
)

private fun solution(park: Array<String>, routes: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    val map = Array(park.size) { mutableListOf<Char>() }

    repeat(park.size) {
        map[it] = park[it].map { it }.toMutableList()
    }
    var currrentPosition = 0 to 0
    map.forEachIndexed { col, chars ->
        chars.forEachIndexed { row, c ->
            if (map[col][row] == 'S') {
                val v = move(col, row, map, routes)
                answer = intArrayOf(v.first, v.second)
            }
        }
    }

    return answer
}

fun move(col: Int, row: Int, map: Array<MutableList<Char>>, routes: Array<String>): Pair<Int, Int> {
    var sPositionCol = col
    var sPositionRow = row

    var currentCol = col
    var currentRow = row
    routes.forEach {
        val move = dir[it.split(" ")[0]]!!
        val count = it.split(" ")[1]!!.toInt()
        for (i in 0 until count) {
            currentCol += move.first
            currentRow += move.second
            if (currentCol < 0 || currentRow < 0 || currentCol >= map.size || currentRow >= map[0].size || map[currentCol][currentRow] == 'X' ) {
                currentCol = sPositionCol
                currentRow = sPositionRow
                break
            }
        }

        sPositionCol = currentCol
        sPositionRow = currentRow

    }
    return currentCol to currentRow
}


