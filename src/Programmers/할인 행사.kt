package Programmers

class `할인 행사` {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = mutableMapOf<String, Int>()
        want.forEachIndexed { index, s ->
            wantMap[want[index]] = number[index]
        }
        for (start in 0..discount.size - 10) {
            val cartMap = mutableMapOf<String, Int>()
            for (i in start until start + 10) {
                cartMap[discount[i]] = cartMap.getOrDefault(discount[i], 0) + 1
            }
            if (wantMap.all { (item, count) ->
                    cartMap[item] == count
                }) {
                answer++
            }
        }

        return answer
    }
}

fun main() {
    println( `할인 행사`().solution(arrayOf("banana", "apple", "rice", "pork", "pot"), intArrayOf(3, 2, 2, 2, 1), arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")))
//    println( `할인 행사`().solution(arrayOf("apple"), intArrayOf(10), arrayOf("banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana")))
}