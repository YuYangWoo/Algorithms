package baekjoon

private val dir = arrayOf(
    0 to 1,
    0 to -1,
    1 to 0,
    -1 to 0,
    1 to 1,
    -1 to 1,
    -1 to -1,
    1 to -1
)

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (row, col) = readLine().split(" ").map { it.toInt() }

        if (row == 0 && col == 0) break
        val map = Array(col) { mutableListOf<Int>() }
        val adjacent = Array(col) { BooleanArray(row) }

        repeat(col) {
            map[it] = readLine().split(" ").map { it.toInt() }.toMutableList()
        }

        var count = 0
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (adjacent[i][j].not() && map[i][j] == 1) {
                    dfs(i, j, map, adjacent)
                    count++
                }
            }
        }
        println(count)
    }
}

private fun dfs(col: Int, row: Int, map: Array<MutableList<Int>>, adjacent: Array<BooleanArray>) {
    adjacent[col][row] = true
    for (dir in dir) {
        val dirRow = row + dir.first
        val dirCol = col + dir.second

        if (dirRow >= 0 && dirCol >= 0 && dirRow < map[0].size && dirCol < map.size && map[dirCol][dirRow] == 1 && adjacent[dirCol][dirRow].not()) {
            dfs(dirCol, dirRow, map, adjacent)
        }
    }
}
