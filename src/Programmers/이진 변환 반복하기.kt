package Programmers

class `이진 변환 반복하기` {
    fun solution(s: String): IntArray {
        var target = s
        var count = 0
        var zeroCount = 0

        while (target != "1") {
            count++
            val noZeroS = target.replace("0", "")
            zeroCount += kotlin.math.abs(target.length - noZeroS.length)
            target = Integer.toBinaryString(noZeroS.length)
        }

        intArrayOf(count, zeroCount).forEach { println(it) }
        return intArrayOf(count, zeroCount)
    }
}

fun main() {
    val 이진변환 = `이진 변환 반복하기`()
    이진변환.solution("1111111")
}