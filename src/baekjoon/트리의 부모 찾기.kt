package baekjoon

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine()!!.toInt()
    val adjacent = Array(N + 1) { arrayListOf<Int>() }
    var isVisited = BooleanArray(N + 1)
    val root = 1
    val map = HashMap<Int, Int>()
    repeat(N - 1) {
        var (a,b) = readLine()!!.split(" ").map { it.toInt() }
        adjacent[a].add(b)
        adjacent[b].add(a)
    }
    dfs(root, N, adjacent, isVisited, map)

    map.forEach { (t, u) ->
        println(u)
    }
}
private fun dfs(root: Int, N: Int, adjacent: Array<ArrayList<Int>>, isVisited: BooleanArray, map: HashMap<Int, Int>) {
    if (isVisited.filter { it }.size == isVisited.size -1) return
    isVisited[root] = true
    for (i in 1 until adjacent.size) {
        if (!isVisited[i] && adjacent[root].contains(i)) {
            map[i] = root
            dfs(i, N, adjacent, isVisited, map)
        }
    }

}


