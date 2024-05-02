package baekjoon

import java.util.*

var dX = intArrayOf(1, 0, -1, 0)
var dY = intArrayOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine()!!.toInt()
    repeat(T) {
        val (M, N, K) = readLine()!!.split(" ").map { it.toInt() }
        val cabbages = Array(M) { IntArray(N) }
        val isChecked = Array(M) { BooleanArray(N) }
        var count = 0
        repeat(K) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            cabbages[x][y] = 1
        }
        for (i in cabbages.indices) {
            for (j in cabbages[0].indices) {
                if (cabbages[i][j] == 1 && !isChecked[i][j]) {
                    startBfs(i, j, cabbages, M, N, isChecked)
                    count++
                }
            }
        }
        println(count)
    }

}

fun startBfs(i: Int, j: Int, cabbages: Array<IntArray>, M: Int, N: Int, isChecked: Array<BooleanArray>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(i, j))
    isChecked[i][j] = true
    while(queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (move in 0..3) {
            val ix = x + dX[move]
            val iy = y + dY[move]

            if (ix >= 0 && iy >= 0 && ix < M && iy < N && cabbages[ix][iy] == 1 && !isChecked[ix][iy]) {
                queue.add(Pair(ix, iy))
                isChecked[ix][iy] = true
            }
        }
    }
}

