package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { mutableListOf<Int>() }
    repeat(n) {
        val input = readLine().split(" ").map { it.toInt() }.toMutableList()
        map[it] = input
    }
    val isVisited = Array(n) { BooleanArray(m) }
    val queue: Queue<Pair<Int, Pair<Int,Int>>> = LinkedList()

    val answers = Array(n) {IntArray(m)}
    for(i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 2) {
                isVisited[i][j] = true
                queue.add(0 to (i to j))
            }
        }
    }
    bfs(queue, isVisited, answers, map, n, m)

    for(i in answers.indices) {
        for (j in answers[i].indices) {
            if (map[i][j] == 1 && answers[i][j] == 0) {
                answers[i][j] = -1
            }
        }
    }
    answers.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}
private fun bfs(queue: Queue<Pair<Int, Pair<Int,Int>>>, isVisited: Array<BooleanArray>, answers: Array<IntArray>, map: Array<MutableList<Int>>, n: Int, m: Int) {
    while (queue.isNotEmpty()) {
        val top = queue.poll()

        for (dir in dir) {
            val dirCol = top.second.first + dir.first
            val dirRow = top.second.second + dir.second

            if (dirCol < 0 || dirRow < 0 || dirCol >= n || dirRow >= m || map[dirCol][dirRow] == 0 || !isVisited[dirCol][dirRow].not()) continue
            queue.add(top.first + 1 to (dirCol to dirRow))
            isVisited[dirCol][dirRow] = true
            answers[dirCol][dirRow] = top.first + 1
        }


    }
}

private val dir = arrayOf(
    0 to 1,
    0 to -1,
    1 to 0,
    -1 to 0
)