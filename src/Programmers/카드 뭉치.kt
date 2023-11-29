class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        val cards1List = cards1.toMutableList()
        val cards2List = cards2.toMutableList()

        goal.map { goalItem ->
            if (cards1List.size != 0 && goalItem == cards1List.first()) {
                cards1List.removeAt(0)
            } else if (cards2List.size != 0 && goalItem == cards2List.first()) {
                cards2List.removeAt(0)
            } else {
                return "No"
            }
        }
        return "Yes"
    }
}

fun main() {
    Solution().solution(arrayOf("i", "water", "drink"), arrayOf("want", "to"), arrayOf("i", "want", "to", "drink", "water"))
}