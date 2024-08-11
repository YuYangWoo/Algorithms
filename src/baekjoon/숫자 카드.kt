package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val ownCards = mutableListOf<Int>()
    val targetCards = mutableListOf<Int>()
        readLine().split(" ").map { it.toInt() }.toMutableList().forEach {
            ownCards.add(it)
        }

    val M = readLine().toInt()
        readLine().split(" ").map { it.toInt() }.toMutableList().forEach {
            targetCards.add(it)
        }

    val answers = mutableListOf<Int>()

    val ownCardsMap = ownCards.groupingBy { it }.eachCount().toMutableMap()

    targetCards.forEach {
        if (ownCardsMap.contains(it)) {
            answers.add(1)
        } else {
            answers.add(0)
        }
    }

    println(answers.joinToString(" "))
}