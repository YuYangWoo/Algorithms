package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (A, B) = readLine().split(" ").map { it.toLong() }
    val queue: Queue<Pair<Int, Long>> = LinkedList()

    queue.add(1 to A)

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        val count = top.first
        val method1 = top.second * 2
        val method2 = top.second * 10 + 1

        if (method1 < B) {
            queue.add(count + 1 to method1)
        }
        if (method2 < B) {
            queue.add(count + 1 to method2)
        }
        if (method1 == B || method2 == B) {
            println(count + 1)
            return@with
        }
    }
    println(-1)
}