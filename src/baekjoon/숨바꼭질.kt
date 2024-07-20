package baekjoon

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (N, K) = readLine().split(' ').map { it.toInt() }
    val queue: Queue<Int> = LinkedList()
    val isVisited = BooleanArray(100001)
    queue.add(N)

    var count = 0
    while(queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val top = queue.poll()

            if (top == K) {
                println(count)
                return@with
            }

            for (j in 0..2) {
                when(j) {
                    0 -> { // +1
                        val target = top + 1
                        if (target in 0..100000 && isVisited[target].not()) {
                            queue.add(target)
                            isVisited[target] = true
                        }
                    }
                    1 -> { // -1
                        val target = top - 1
                        if (target in 0..100000 && isVisited[target].not()) {
                            queue.add(target)
                            isVisited[target] = true
                        }
                    }
                    2 -> { // *2
                        val target = top * 2
                        if (target in 0..100000 && isVisited[target].not()) {
                            queue.add(target)
                            isVisited[target] = true
                        }
                    }
                }
            }

        }
        count++

    }

}