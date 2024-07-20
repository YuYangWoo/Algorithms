package baekjoon

import 렛코드.isValid

private var localArea = 1
fun main() = with(System.`in`.bufferedReader()) {
    val (M, N, K) = readLine().split(" ").map { it.toInt() }
    val map = Array(M) {IntArray(N)}

    repeat(K) {
        val (x1,y1,x2,y2) = readLine().split(" ").map { it.toInt() }
        for (i in y1  until y2) {
            for (j in x1 until x2) {
                map[i][j] = 1
            }
        }
    }
    val isVisited = Array(M) {BooleanArray(N)}
    var count = 0
    val areas = mutableListOf<Int>()
    for(i in map.indices) {
        for (j in map[i].indices) {
            if (isVisited[i][j].not() && map[i][j] == 0) {
                localArea = 1
                dfs(i,j,isVisited, map, localArea)
                areas.add(localArea)
                count++
            }
        }
    }

    println(count)
    areas.sorted().forEach { print("$it ") }
}

private fun dfs(col: Int, row: Int, visited: Array<BooleanArray>, map: Array<IntArray>, area: Int) {
    visited[col][row] = true
    for (dir in dir) {
        val dirCol = col + dir.first
        val dirRow = row + dir.second

        if (dirCol >= 0 && dirRow >= 0 && dirCol < map.size && dirRow < map[0].size && visited[dirCol][dirRow].not() && map[dirCol][dirRow] == 0) {
            dfs(dirCol, dirRow, visited, map, localArea++)
        }
    }
}

private val dir = arrayOf(
    0 to 1,
    0 to -1,
    1 to 0,
    -1 to 0
)