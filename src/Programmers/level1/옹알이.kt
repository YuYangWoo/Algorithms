package Programmers.level1

class 옹알이 {
    fun solution(babbling: Array<String>): Int {
        val pronunciations = mutableListOf("aya", "ye", "woo", "ma")
        var count = 0
        for (item in babbling) {
            var bab = item
            for (pronunciation in pronunciations) {
                if (bab.contains(pronunciation + pronunciation) || bab.isEmpty()) break
                if (bab.contains(pronunciation)) {
                    bab = bab.replace(pronunciation, " ")
                }
            }
            if (bab.replace(" ", "").isEmpty()) count++
        }
        return count
    }
}

fun main() {
    println(옹알이().solution(arrayOf("ayamayaa")))
}