package baekjoon

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (sero, garo) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(sero) { mutableListOf<Int>() }
    val isVisited = Array(sero) { BooleanArray(garo) }
    val countMap = Array(sero) { IntArray(garo) }.apply {
        this[0][0] = 1
    }

    repeat(sero) {
        map[it] = readLine()!!.map { it.toString().toInt() }.toMutableList()
    }

    for (i in 0 until sero) {
        for (j in 0 until garo) {
            if (!isVisited[i][j] && map[i][j] == 1) {
                bfs(i, j, map, countMap, isVisited, sero, garo)
            }
        }
    }
    print(countMap[sero - 1][garo - 1])
}

private fun bfs(
    col: Int,
    row: Int,
    map: Array<MutableList<Int>>,
    countMap: Array<IntArray>,
    isVisited: Array<BooleanArray>,
    sero: Int,
    garo: Int
) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(row to col)
    isVisited[col][row] = true
    while (queue.isNotEmpty()) {
        val point = queue.poll()

        for (dir in dir) {
            val dirGaro = point.first + dir.first
            val dirSero = point.second + dir.second
            if (dirGaro >= 0 && dirSero >= 0 && dirGaro < garo && dirSero < sero && !isVisited[dirSero][dirGaro] && map[dirSero][dirGaro] == 1) {
                queue.add(dirGaro to dirSero)
                isVisited[dirSero][dirGaro] = true
                countMap[dirSero][dirGaro] = countMap[point.second][point.first] + 1
            }
        }
    }

}

private val dir = arrayOf(
    0 to 1,
    1 to 0,
    -1 to 0,
    0 to -1
)
