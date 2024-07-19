package baekjoon

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, K, X) = readLine().split(" ").map { it.toInt() }
    val adjacent = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        adjacent[a].add(b)
    }
    val isVisited = IntArray(N + 1) { -1 }
    val queue: Queue<Int> = LinkedList()
    queue.add(X)
    isVisited[X] = 0
    while (queue.isNotEmpty()) {
        val point = queue.poll()
        for (i in adjacent[point]) {
            if (isVisited[i] == -1) {
                isVisited[i] = isVisited[point] + 1
                queue.add(i)
            }
        }
    }

    if (isVisited.none { it == K }) {
        println("-1")
    } else {
        isVisited.forEachIndexed { index, i ->
            if (i == K) {
                println(index)
            }
        }
    }
}