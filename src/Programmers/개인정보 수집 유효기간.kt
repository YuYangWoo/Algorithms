package Programmers

import java.lang.Math.abs

class `개인정보 수집 유효기간` {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): MutableList<Int> {
        var answer = mutableListOf<Int>()

        val typeMap = terms.associate {
            val (key, value) = it.split(" ")
            key to value.toInt()
        }
        privacies.forEachIndexed { index, s ->
            val type = s.split(" ")[1]
            val record = (typeMap[type] ?: 0) * 28

            val targetTime = privacies[index].split(" ")[0]

            if (record < getDaysBetween(today, targetTime)) {
                answer.add(index + 1)
            }
        }

        println(answer.toString())
        return answer
    }

    private fun getDaysBetween(today: String, target: String): Int {
        val todayArray = today.split(".")
        val targetArray = target.split(".")

        val year = todayArray[0].toInt() - targetArray[0].toInt()
        val month = todayArray[1].toInt() - targetArray[1].toInt()
        val day = todayArray[2].toInt() - targetArray[2].toInt()

        return (year * 12 * 28) + (if(month >= 0) month * 28 else abs(month) * 28 * -1) + (day) +1

    }
}

fun main() {
    `개인정보 수집 유효기간`().solution("2022.05.19", arrayOf("A 6", "B 12", "C 3"), arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"))
}

