package baekjoon

private val dir = arrayOf(
    0 to 1,
    1 to 0,
    -1 to 0,
    0 to -1,
)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { mutableListOf<Int>() }
    val isVisited = Array(n) { BooleanArray(m) }
    var paint = 0
    repeat(n) {
        map[it] = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j] && map[i][j] == 1) {
                paint++
                area = 1
                dfs(i, j ,n, m, map, isVisited)
                areaList.add(area)
            }
        }
    }
    println(paint)
    println(areaList.maxOrNull() ?: 0)
}
var area = 1

private fun dfs(
    sero: Int,
    garo: Int,
    col: Int,
    row: Int,
    map: Array<MutableList<Int>>,
    isVisited: Array<BooleanArray>
) {
    isVisited[sero][garo] = true
    for (dir in dir) {
        val dirRow = garo + dir.first
        val dirCol = sero + dir.second

        if (dirRow >= 0 && dirCol >= 0 && dirRow < row && dirCol < col && !isVisited[dirCol][dirRow] && map[dirCol][dirRow] == 1) {
            dfs(dirCol, dirRow, col, row, map, isVisited)
            area++
        }
    }

}
val areaList = mutableListOf<Int>()