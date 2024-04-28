package 렛코드

fun main() {
    twoSum(intArrayOf(2, 7, 11, 15), 9).forEach { println(it) }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { index, num ->
        map[target - num]?.let { return intArrayOf(it, index) }
        map[num] = index
    }
    return intArrayOf()
}