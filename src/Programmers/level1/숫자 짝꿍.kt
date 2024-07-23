package Programmers.level1

import kotlin.math.min

class `숫자 짝꿍` {
    fun solution(X: String, Y: String): String {
        val xMap = mutableMapOf<Int, Int>()
        val yMap = mutableMapOf<Int, Int>()
        X.forEach {
            xMap[it.toString().toInt()] = (xMap[it.toString().toInt()] ?: 0) + 1
        }
        Y.forEach {
            yMap[it.toString().toInt()] = (yMap[it.toString().toInt()] ?: 0) + 1
        }

        val list = mutableListOf<Int>()
        xMap.forEach { item ->
            if (yMap.contains(item.key)) {
                repeat(min(item.value, yMap[item.key]!!)) {
                    list.add(item.key)
                }
            }
        }
        if (list.isEmpty()) {
            list.add(-1)
        } else if (list.all { it == 0 }) {
            list.clear()
            list.add(0)
        }

        return list.sorted().reversed().joinToString("")
    }
}

fun main() {
    println(`숫자 짝꿍`().solution("5525", "1255"))
}