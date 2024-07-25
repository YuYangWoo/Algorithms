package Programmers.level1

class `문자열 나누기` {
    fun solution(s: String): Int {
        var answer: Int = 0
        var x = s[0]
        val xNot = s.filter { it != x }
        var xCount = 0
        var xNotCount = 0

        for (i in s.indices) {
            if (x == s[i]) xCount++
            else xNotCount++

            if (xCount == xNotCount) {
                answer++
                if (i + 1 < s.length) {
                    x = s[i + 1]
                }
                xCount = 0
                xNotCount = 0
            }
        }
        if (xCount !=0 || xNotCount!= 0) {
            answer++
        }
        return answer
    }
}

fun main() {
    println(`문자열 나누기`().solution("aaabbaccccabba"))
}