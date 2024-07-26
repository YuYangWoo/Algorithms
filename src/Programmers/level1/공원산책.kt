package Programmers.level1

class 공원산책 {
    private val dir = mutableMapOf<String, Pair<Int, Int>>(
        "E" to (0 to 1),
        "W" to (0 to -1),
        "N" to (-1 to 0),
        "S" to (1 to 0)
    )

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val map = Array(park.size) { mutableListOf<Char>() }.apply {
            park.forEachIndexed { index, item ->
                item.forEachIndexed { i, c ->
                    this[index].add(c)
                }
            }
        }
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (map[i][j] == 'S') {
                    return move(i, j, routes, map)
                }
            }
        }

        return answer
    }

    private fun move(col: Int, row: Int, routes: Array<String>, map: Array<MutableList<Char>>): IntArray {
        var currentDirCol = col
        var currentDirRow = row
        var sCol = col
        var sRow = row

        for (i in routes.indices) {
            val direction = routes[i].split(" ")[0]
            val point = routes[i].split(" ")[1]

            for (i in 0 until point.toInt()) {
                sCol += dir[direction]!!.first
                sRow += dir[direction]!!.second
                if (sCol >= 0 && sRow >= 0 && sCol < map.size && sRow < map[0].size && map[sCol][sRow] != 'X' ) {

                } else {
                    sCol = currentDirCol
                    sRow = currentDirRow
                    break
                }
            }

            currentDirCol = sCol
            currentDirRow = sRow
        }
        return intArrayOf(sCol, sRow)
    }

}




fun main() {
//    println(공원산책().solution(arrayOf("SOO","OOO","OOO"), arrayOf("E 2","S 2","W 1")))
//    println(공원산책().solution(arrayOf("OSO","OOO","OXO","OOO"), arrayOf("E 2","S 3","W 1")))
    println(공원산책().solution(arrayOf("SOO","OXX","OOO"), arrayOf("E 2","S 2","W 1")))
}