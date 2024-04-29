import kotlin.math.sqrt

fun main() {
//    solution(5, 3, 2)
    solution(10, 3, 2)
}

fun solution(number: Int, limit: Int, power: Int): Int {

    /**
     * number 5
     * 1, 2, 3, 4, 5
     * 해당 수의 제곱근을 구한다.
     * ex 10에 대해 알아보자
     * 루트10
     */
    val list = mutableListOf<Int>()
    for (i in 1 .. number) {
        val route = sqrt(i.toDouble()).toInt()
        var count = 0
        (1..route).filter { i % it == 0 }.forEach {
            count += if (i / it == it) 1 else 2
        }
        list.add(count)
    }
    list.forEachIndexed { index, item ->
        if (item > limit) {
            list[index] = power
        }
    }
    println(list.sum())
    return list.sum()
}