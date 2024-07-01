package Programmers

class `멀리 뛰기` {
    fun solution(n: Int): Long {
        val list = mutableListOf<Long>().apply {
            add(1)
            add(2)
        }
        repeat(n - 2) {
            list.add((list[it] + list[it + 1]) % 1234567)
        }

        return list[n-1]
    }
}

fun main() {
    println(`멀리 뛰기`().solution(8))
}