fun main() {
    solution("3141592", "271")
}

fun solution(t: String, p: String): Long {
    var answer: Long = 0L
    var start = 0
    var end = p.length
    val splitedArray = mutableListOf<Long>()

    t.forEach {
        if (t.length < end) return@forEach
        splitedArray.add(t.substring(start, end).toLong())
        start ++
        end ++
    }

    splitedArray.forEach {
        if (it.toLong() <= p.toLong()) {
            answer ++
        }
    }
    return answer
}