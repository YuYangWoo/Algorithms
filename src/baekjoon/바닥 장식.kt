package baekjoon

private val dxx = arrayOf(0, 0, -1, 1)
private val dyy = arrayOf(-1, 1, 0 ,0)

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val rooms = Array(N) { CharArray(M) }
    val isVisited = Array<BooleanArray>(N) { BooleanArray(M) }
    var count = 0

    repeat(N) {
        val a = readLine()!!.toCharArray()
        for (i in a.indices) {
            rooms[it][i] = a[i]
        }
    }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (!isVisited[i][j] && rooms[i][j] == '-') {
                dfs(i, j, rooms, isVisited, N, M, '-', 0, 1)
                count++
            }
        }

        for (i in 0 until M) {
            for (j in 0 until N) {
                if (!isVisited[j][i] && rooms[j][i] == '|') {
                    dfs(j, i, rooms, isVisited, N, M, '|',2,3 )
                    count++
                }
            }
        }

    }

    println(count)

}

fun dfs(x: Int, y: Int, rooms: Array<CharArray>, isVisited: Array<BooleanArray>, N: Int, M: Int, flag: Char,startIndex:Int, endIndex: Int) {
    isVisited[x][y] = true

    for (i in startIndex..endIndex) {
        val ix = x + dxx[i]
        val iy = y + dyy[i]

        if (ix >= 0 && iy >= 0 && ix < N && iy < M && rooms[ix][iy] == flag && !isVisited[ix][iy]) {
            dfs(ix, iy, rooms, isVisited, N, M, flag,startIndex, endIndex)
        }
    }
}