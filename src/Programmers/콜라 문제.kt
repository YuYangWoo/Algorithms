package Programmers

fun main() {
    println(solution(2, 1, 20))
}
fun solution(a: Int, b: Int, n: Int): Int {
    var answer: Int = 0
    var totalCola = n
    while(true) {
        if (totalCola < a) break
        var getColaCount = ((totalCola / a) * b)
        totalCola = totalCola - ( a * (totalCola / a)) + ((totalCola / a) * b)
        answer += getColaCount
    }
    return answer
}