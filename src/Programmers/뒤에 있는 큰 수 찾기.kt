package Programmers

import java.util.*
import kotlin.math.min

class `뒤에 있는 큰 수 찾기` {
    fun solution(numbers: IntArray): List<Int> {
        val originalStack: Stack<Int> = Stack<Int>()
        val bigStack = Stack<Int>()
        val answerList = mutableListOf<Int>()
        numbers.forEach {
            originalStack.push(it)
        }
        while(originalStack.isNotEmpty()) {
            val top = originalStack.pop()

            if (bigStack.isEmpty()) {
                answerList.add(-1)
                bigStack.add(top)

            } else {
                for (i in bigStack.indices) {
                    val bigTop = bigStack.peek()
                    if (top < bigTop) {
                        answerList.add(bigTop)
                        break
                    } else {
                        bigStack.pop()
                    }
                }
                if(bigStack.isEmpty()) answerList.add(-1)
                bigStack.add(top)
            }

        }
        return answerList.reversed()
    }
}

fun main() {
    println(`뒤에 있는 큰 수 찾기`().solution(intArrayOf(9, 1, 5, 3, 6, 2)))
}