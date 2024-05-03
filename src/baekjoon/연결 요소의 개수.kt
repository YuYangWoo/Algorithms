package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val adjacentList = Array(N + 1) { IntArray(N + 1) }
    val isVisited = BooleanArray(N + 1)
    var answer = 0

    repeat(M) {
        val (u, v) = readLine()!!.split(" ").map { it.toInt() }
        adjacentList[u][v] = 1
        adjacentList[v][u] = 1
    }
    for (i in 1..N) {
        for (j in 1..N) {
            if (!isVisited[i]) {
                dfs(i, adjacentList, isVisited, N)
                answer++
            }
        }
    }

    print(answer)
}

fun dfs(start: Int, adjacentList: Array<IntArray>, isVisited: BooleanArray, N: Int) {
    isVisited[start] = true

    for (i in 1..N) {
        if (adjacentList[start][i] == 1 && !isVisited[i]) {
            dfs(i,adjacentList, isVisited, N )
        }
    }

}