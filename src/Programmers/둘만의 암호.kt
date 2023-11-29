fun main() {
    // abcdefghijklmnopqrstuvwxyz 97..122
    solution("klmnx", "abcdefghij", 20)
//    solution("adhkmx", "bdqw", 5) // himpse
}

    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        val list = ArrayList<Char>()
        for (item in 97..122) {
            if (skip.contains(item.toChar())) continue
            list.add(item.toChar())
        }

        s.forEach {
            val firstIndex = list.indexOf(it)
            var targetIndex = firstIndex + index
            answer += if (targetIndex < list.size) {
                list[targetIndex]
            } else {
                while (targetIndex >= list.size) {
                    targetIndex -= list.size
                }
                list[targetIndex]
            }
        }
        return answer
    }