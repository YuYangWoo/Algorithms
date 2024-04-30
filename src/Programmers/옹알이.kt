package Programmers

fun main() {
    println(solution(arrayOf("yewooye", "yeye")))
}

fun solution(babbling: Array<String>): Int {
    var answer: Int = 0
    val list = listOf<String>("aya", "ye", "woo", "ma")
    babbling.forEach { babbling ->
        var temp = babbling
        list.forEach { item ->
            if (temp.contains("${item}${item}"))
                return@forEach
            else temp = temp.replace(item, " ")
        }
        if (temp.replace(" ", "").isEmpty()) answer++
    }
    return answer
}