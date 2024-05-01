package baekjoon

import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (N,M,V) = readLine()!!.split(" ").map { it.toInt() } // 4 5 1
    val adjacent = Array<IntArray>(N + 1) { IntArray(N + 1) }
    var isVisited = BooleanArray(N + 1)
    repeat(M) {
        var (a,b) = readLine()!!.split(" ").map { it.toInt() }
        adjacent[a][b] = 1
        adjacent[b][a] = 1
    }
    dfs(N, V, isVisited, adjacent)
    println()
    isVisited.fill(false)
    bfs(N, V, isVisited, adjacent)
}

fun dfs(N: Int, V: Int, isVisited: BooleanArray, adjacent: Array<IntArray>) {
    print("${V} ")
    isVisited[V] = true
    for (i in 1 ..N) {
        if (!isVisited[i] && adjacent[V][i] == 1) {
            dfs(N, i, isVisited, adjacent)
        }
    }

}

fun bfs(N: Int, V: Int, isVisited: BooleanArray, adjacent: Array<IntArray>) {
    val queue = LinkedList<Int>()
    queue.add(V)
    isVisited[V] = true
    while(queue.isNotEmpty()) {
        val point = queue.pop()
        print("${point} ")
        for (i in 1..N) {
            if (!isVisited[i] && adjacent[point][i] == 1) {
                isVisited[i] = true
                queue.add(i)
            }
        }
    }
}

