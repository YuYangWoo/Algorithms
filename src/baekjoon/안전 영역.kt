package baekjoon

import kotlin.math.max

private val dir = arrayOf(
    0 to 1,
    0 to -1,
    1 to 0,
    -1 to 0,
)

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val map = Array(N) { mutableListOf<Int>() }
    repeat(N) {
        map[it] = readLine().split(" ").map { it.toInt() }.toMutableList()
    }
    val maxHeight = map.maxOf { it.maxOf { it } }
    var start = 0
    var answer = 0
    while(start != maxHeight) {
        val isVisited = Array(N) {BooleanArray(N)}
        var count = 0
        for(i in map.indices) {
            for (j in map[i].indices) {
                if (isVisited[i][j].not() && map[i][j] > start) {
                    dfs(isVisited, map, i, j, start)
                    count++
                }
            }
        }
        answer = max(answer, count)
        start++
    }
    println(answer)
}

fun dfs(visited: Array<BooleanArray>, map: Array<MutableList<Int>>, col: Int, row: Int, start: Int) {
    visited[col][row] = true

    for (dir in dir) {
        val dirCol = col + dir.first
        val dirRow = row + dir.second

        if (dirCol >= 0 && dirRow >= 0 && dirCol < map.size && dirRow < map[col].size && visited[dirCol][dirRow].not() && map[dirCol][dirRow] > start) {
            dfs(visited, map, dirCol, dirRow, start)
        }
    }

}

