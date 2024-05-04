package Programmers

fun main() {
    solution(arrayOf("BACDE", "ABCD"), arrayOf("ABCDW", "FGHIJ", "WA", )).forEach { println(it) }
}

private fun solution(keymap: Array<String>, targets: Array<String>): MutableList<Int> {
    var answer = mutableListOf<Int>()
    val minKeyMap = HashMap<Char, Int>()
    buildMinKey(keymap, minKeyMap)

    targets.forEach { target ->
        var count = 0
        var flag = false
        target.forEach {
            if (minKeyMap.containsKey(it) && !flag) {
                count += minKeyMap[it]!!
            } else {
                flag = true
                count = -1
            }
        }
        answer.add(count)
    }

    return answer
}

fun buildMinKey(keymap: Array<String>, minKeyMap: HashMap<Char, Int>) {
    keymap.forEach { key ->
        key.forEachIndexed { index, literal ->
            minKeyMap[literal] = minOf(minKeyMap[literal] ?: (index + 1), index + 1)
        }
    }
}
