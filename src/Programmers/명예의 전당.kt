import java.util.*
import kotlin.collections.ArrayList

fun main() {
    solution(4, intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000))
}

fun solution(k: Int, score: IntArray): IntArray {
    var list = ArrayList<Int>()
    val answer = ArrayList<Int>()

    score.mapIndexed { index, item ->
        if (index >= k) {
            if (Collections.min(list) < item) {
                list.add(item)
                list.remove(Collections.min(list))
            }
        }
        else {
            list.add(item)
        }
        list.sort()

        answer.add(list.first())
    }

    return answer.toIntArray()
}