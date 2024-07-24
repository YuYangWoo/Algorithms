package Programmers.level1

class 체육복 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val clothes = IntArray(n){ 1 }
        lost.forEach {
            clothes[it - 1] = clothes[it - 1] - 1
        }
        reserve.forEach {
            clothes[it - 1] = clothes[it - 1] + 1
        }
        clothes.forEachIndexed { index, item ->
            if (clothes[index] == 0) {
                if (index - 1 >= 0 && clothes[index - 1] >= 2 ) {
                    clothes[index] = clothes[index] + 1
                    clothes[index - 1] = clothes[index - 1] -1
                } else if (index + 1 < n && clothes[index + 1] >=2) {
                    clothes[index] = clothes[index] + 1
                    clothes[index + 1] = clothes[index + 1] -1
                }
            }
        }

        return clothes.filter { it >= 1 }.size
    }
}

fun main() {
    println(체육복().solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
//    println(체육복().solution(5, intArrayOf(2, 4), intArrayOf(3)))
//    println(체육복().solution(3, intArrayOf(3), intArrayOf(1)))
}