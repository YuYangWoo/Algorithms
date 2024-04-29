package 렛코드

import java.util.Stack

fun main() {
    println(isValid("()"))
}
fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach {
        if (stack.isNotEmpty()) {
            when ("${stack.peek()}${it}") {
                "()", "[]", "{}" -> {
                    stack.pop()
                    return@forEach
                }
            }
        }
        stack.push(it)

    }
    return stack.isEmpty()
}