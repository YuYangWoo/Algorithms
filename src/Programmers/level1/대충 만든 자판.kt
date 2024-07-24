package Programmers.level1

import kotlin.math.min

class `대충 만든 자판` {
    fun solution(keymap: Array<String>, targets: Array<String>): MutableList<Int> {
        var answer = mutableListOf<Int>()

        val minKeyMap = buildMinKey(keymap)

        targets.forEach { target ->
            var count = 0
            for (i in target.indices) {
                val n = minKeyMap[target[i]] ?: -1
                if (n == -1) {
                    count = -1
                    break
                }
                else count += n
            }
            answer.add(count)
        }
        return answer
    }

    private fun buildMinKey(keymap: Array<String>): MutableMap<Char, Int> {
        return mutableMapOf<Char, Int>().apply {
            keymap.forEachIndexed { index, keyString ->
                keyString.forEachIndexed { index, c ->
                    this[c] = min(this[c] ?: (index + 1), index + 1)
                }
            }
        }
    }
}

fun main() {
    println(`대충 만든 자판`().solution(arrayOf("ABC"), arrayOf("DA")))
}