package Programmers

import java.util.*

class `괄호 회전하기` {

    fun solution(s: String): Int {
        var answer: Int = 0
        var rotateString = s
        for (i in s.indices) {
            val rotatedString = rotateString.substring(1, rotateString.length) + rotateString.substring(0, 1)
            rotateString = rotatedString

            val stack = Stack<Char>()

            rotatedString.forEach {
                when (it) {
                    '(', '[', '{' -> {
                        stack.push(it)
                    }
                    else -> {
                        if (stack.isEmpty()) {
                            stack.push(it)
                        }
                        val top = stack.peek()
                        if (top == '(' && it == ')') {
                            stack.pop()
                        } else if (top == '[' && it == ']') {
                            stack.pop()
                        } else if (top == '{' && it == '}') {
                            stack.pop()
                        } else {
                            return@forEach
                        }
                    }
                }
            }
            if (stack.size == 0) {
                answer++
            }

        }

        return answer
    }

}

fun main() {
    println(`괄호 회전하기`().solution("}}}"))
}