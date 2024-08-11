package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n + 1) { BooleanArray(n + 1) }

    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }

        map[a][b] = true
        map[b][a] = true
    }
    val kevinBacons = IntArray(n + 1)
    for (i in 1 .. n) {
        val isVisited = IntArray(n + 1)

        val queue: Queue<Int> = LinkedList()
        queue.add(i)
        isVisited[i] = 1
        while (queue.isNotEmpty()) {
            val top = queue.poll()

            for (j in 1 until map.size) {
                if (map[top][j] && isVisited[j] == 0) {
                    isVisited[j] = isVisited[top] + 1
                    queue.add(j)
                }
            }
        }
        kevinBacons[i] = isVisited.sum()
    }

    kevinBacons[0] = Int.MAX_VALUE
    println(    kevinBacons.indexOfFirst { it == kevinBacons.min() })
}


