package Programmers

class 바탕화면정리 {

    fun solution(wallpaper: Array<String>): IntArray {
        val xArray = ArrayList<Int>()
        val yArray = ArrayList<Int>()
        wallpaper.forEachIndexed { i1, s ->
            s.forEachIndexed { i2, c ->
                if (c == '#') {
                    xArray.add(i1)
                    yArray.add(i2)
                }
            }
        }
        val (startX, startY) = xArray.minOf { it } to yArray.minOf { it }
        val (endX, endY) = xArray.maxOf { it } + 1 to yArray.maxOf { it } + 1
        return intArrayOf(startX, startY, endX, endY)
    }
}

fun main() {
    바탕화면정리().solution(arrayOf("..........", ".....#....", "......##..", "...##.....", "....#....."))
}
