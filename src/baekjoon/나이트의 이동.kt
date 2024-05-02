package baekjoon

import java.util.*

val dx = intArrayOf(2, 2, 1, 1, -2, -2, -1, -1)
val dy = intArrayOf(1, -1, 2, -2, 1, -1, 2, -2)

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine()!!.toInt()

    repeat(T) {
        val I = readLine()!!.toInt()
        val (currentX, currentY) = readLine()!!.split(" ").map { it.toInt() }
        val (targetX, targetY) = readLine()!!.split(" ").map { it.toInt() }

        val isVisited = Array<BooleanArray>(I) { BooleanArray(I) }
        val knightPositions = Array<IntArray>(I) { IntArray(I) }

        isVisited[currentX][currentY] = true
        knightPositions[currentX][currentY] = 1

        bfs(I, isVisited, knightPositions, targetX, targetY, currentX, currentY)
        if (currentX == targetX && currentY == targetY) {
            println(0)
        }
    }
}

private fun bfs(I: Int, isVisited: Array<BooleanArray>, knightPositions: Array<IntArray>, targetX: Int, targetY: Int, currentX: Int, currentY: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int,Int>>()
    queue.add(Pair(currentX, currentY))

    while(queue.isNotEmpty()) {
        val (pointX, pointY) = queue.poll()

        for (i in 0 until 8) {
            val ix = pointX + dx[i]
            val iy = pointY + dy[i]

            if (ix >= 0 && iy >= 0 && ix < I && iy < I && !isVisited[ix][iy] && knightPositions[ix][iy] != 1) {
                queue.add(Pair(ix, iy))
                knightPositions[ix][iy] = knightPositions[pointX][pointY] + 1
                isVisited[ix][iy] = true

                if (ix == targetX && iy == targetY) {
                    println(knightPositions[targetX][targetY] - 1)
                }
            }
        }
    }

}