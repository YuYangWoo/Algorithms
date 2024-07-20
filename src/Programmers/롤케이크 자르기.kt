package Programmers

class `롤케이크 자르기` {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val bro1 = IntArray(topping.size)
        val bro2 = IntArray(topping.size)

        val toppingSet = mutableSetOf<Int>()

        topping.forEachIndexed { index, item ->
            toppingSet.add(item)
            bro1[index] = toppingSet.size
        }
        toppingSet.clear()
        for (i in topping.size -1 downTo 0) {
            toppingSet.add(topping[i])
            bro2[i] = toppingSet.size
        }

        for (i in 0 until topping.size -1 ) {
            if(bro1[i] == bro2[i + 1]) answer++
        }

        return answer
    }
}

fun main() {
    println(`롤케이크 자르기`().solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2)))
}