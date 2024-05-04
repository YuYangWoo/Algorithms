package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val count = readLine()!!.toInt()
    val map = Array(n + 1) { IntArray(n+1) }
    val isVisited = BooleanArray(n + 1)
    repeat(count) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        map[x][y] = 1
        map[y][x] = 1
    }

    dfs(1, map, isVisited)
    println(answer)
}
var answer = 0
fun dfs(start: Int, map: Array<IntArray>, isVisited: BooleanArray) {
    isVisited[start] = true

    for (i in 1 until map.size) {
        if (!isVisited[i] && map[start][i] == 1) {
            dfs(i, map, isVisited)
            answer++
        }
    }
}
