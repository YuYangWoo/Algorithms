fun main() {
    solution1(intArrayOf(-2, 3, 0, 2, -5))
}
var answer: Int = 0

fun solution1(number: IntArray): Int {
    var selectedNumber = IntArray(3)
    var targetCount = 0
    var isVisited = BooleanArray(number.size)
    combination(number, targetCount, selectedNumber, 0)
//    permutation(number, isVisited, targetCount, selectedNumber)
    println(answer)

    return answer
}

//fun permutation(number: IntArray, isVisited: BooleanArray, targetCount: Int, selectedNumbers: IntArray) {
//    if (targetCount == selectedNumbers.size) {
//        println(selectedNumbers.joinToString())
//        return
//    }
//
//    for (i in number.indices) {
//        if (!isVisited[i]) {
//            isVisited[i] = true
//            selectedNumbers[targetCount] = number[i]
//            permutation(number, isVisited, targetCount + 1, selectedNumbers)
//            isVisited[i] = false
//        }
//    }
//}

fun combination(number: IntArray, targetCount: Int, selectedNumbers: IntArray, start: Int) {
    if (targetCount == 3) {
        if (selectedNumbers.sum() == 0) answer++
        return
    }

    for (i in start until number.size) {
        selectedNumbers[targetCount] = number[i]
        combination(number, targetCount + 1, selectedNumbers, i + 1)
    }
}
