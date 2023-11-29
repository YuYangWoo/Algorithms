fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    // frodo = 2 neo = 2 apeach 0 muzi = 1 맵에 담고
    // k와 비교해서 k이상인 frodo neo를 신고한 muzi 2번 apeach 1번 frodo 1번 을 리턴한다.
    var linkedHashMap = LinkedHashMap<String, Int>()

   // 정지당한 횟수 카운팅
    report.distinct().forEach {
        linkedHashMap[it.split(" ")[1]] = (linkedHashMap[it.split(" ")[1]] ?: 0) + 1

    }
    val answerMap = LinkedHashMap<String, Int>()
   // 정지된 애들을 찾아냄
    val targetList = linkedHashMap.filter { it.value >= k }

   // 정답 리스트 초기화
   id_list.forEach {
      answerMap[it] = answerMap.getOrDefault(it, 0)
   }

   // 신고대상 중에서 정지대상을 찾아냄
   report.distinct().forEach {
      if (targetList.contains(it.split(" ")[1]))
      answerMap[it.split(" ")[0]] = (answerMap[it.split(" ")[0]] ?: 0) + 1
   }

    return answerMap.values.toIntArray()
}

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report_list = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")

//   val id_list = arrayOf("con", "ryan")
//   val report_list = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
    val k = 2
    val answer = solution(id_list, report_list, k)
    answer.forEach {
        println("$it ")
    }
}
