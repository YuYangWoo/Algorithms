package Programmers.level1

class 콜라 {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var currentCola = n
        while(true) {
            if (currentCola / a == 0) break
            answer += (currentCola / a) * b
            currentCola = currentCola - ((currentCola / a) * a) + (currentCola / a * b)
        }
        return answer
    }
}

fun main() {
    println(콜라().solution(3,2,20))
}