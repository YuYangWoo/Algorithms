fun main() {
    println(solution(arrayOf("may", "kein", "kain", "radi"), intArrayOf(5, 10, 1, 3), arrayOf(arrayOf("may", "kein", "kain", "radi"), arrayOf("may", "kein", "brin", "deny"), arrayOf("kon", "kain", "may", "coni"))))
}

fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    val map = name.zip(yearning.toTypedArray()).toMap()
    return photo.map { photo -> photo.sumOf { map[it] ?: 0 } }.toIntArray()
}