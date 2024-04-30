package Programmers

fun main() {
    println(solution("abracadabra"))
}

fun solution(s: String): Int {
    var answer: Int = 0
    var x = s[0]
    var xCount = 0
    var notXCount = 0
    s.forEachIndexed { index, c ->
        if (c == x) {
            xCount++
        } else {
            notXCount ++
        }
        if (xCount == notXCount) {
            answer++

            if (index + 1 < s.length)
            x = s[index + 1]

            xCount = 0
            notXCount = 0
        }

        if (xCount != notXCount && index + 1 == s.length) {
            answer++
        }
    }

    return answer
}