package baekjoon

private val dir = arrayOf(
    0 to 1,
    -1 to 1,
    -1 to 0,
    -1 to -1,
    0 to -1,
    1 to -1,
    1 to 0,
    1 to 1,
)
fun main() = with(System.`in`.bufferedReader()) {
    while(true) {
        val (row,col) = readLine()!!.split(" ").map { it.toInt() }
        if (row == 0 && col == 0) break

        val map = Array(col) { mutableListOf<Int>() }
        val isVisited = Array(col) { BooleanArray(row) }

        repeat(col) {
            map[it] = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        }

        var count = 0
        for (i in 0 until col) {
            for (j in 0 until row) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    dfs(i, j, map, isVisited, row, col)
                    count++
                }
            }
        }
        println(count)
    }

}

fun dfs(sero: Int, garo: Int, map: Array<MutableList<Int>>, visited: Array<BooleanArray>, row: Int, col: Int) {
    visited[sero][garo] = true

    for (dir in dir) {
        val dirGaro = garo + dir.first
        val dirSero = sero + dir.second

        if (dirGaro >= 0 && dirSero >= 0 && dirGaro < row && dirSero < col && !visited[dirSero][dirGaro] && map[dirSero][dirGaro] == 1) {
            dfs(dirSero, dirGaro, map, visited, row, col)
        }
    }
}
