package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val map = Array(N) { mutableListOf<Int>() }

    repeat(N) {
        map[it] = readLine().split(" ").map { it.toInt() }.toMutableList()
    }
    val answer = Array(N) { IntArray(N) }
    for (i in map.indices) {
        val isVisited = BooleanArray(N)
        dfs(i, map, isVisited, answer)
        isVisited.forEachIndexed { index, b ->
            if (b) {
                answer[i][index] = 1
            }
        }
    }

    answer.forEach {
        it.forEach {
            print(it)
            print(" ")
        }
        println()
    }
}

private fun dfs(start: Int, map: Array<MutableList<Int>>, isVisited: BooleanArray, answer: Array<IntArray>) {
    for(i in map.indices) {
        if (isVisited[i].not() && map[start][i] == 1) {
            isVisited[i] = true
            dfs(i, map, isVisited, answer)
        }
    }
}



