package Programmers

import kotlin.math.max

class `가장 많이 받은 선물` {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {

        val whoGiveMap = mutableMapOf<String, MutableList<String>>()
        val giveMap = mutableMapOf<String, Int>()
        val takeMap = mutableMapOf<String, Int>()

        friends.forEach {
            giveMap[it] = 0
            takeMap[it] = 0
            whoGiveMap[it] = mutableListOf()
        }

        gifts.forEach { gift ->
            val (give, take) = gift.split(" ")
            giveMap[give] = (giveMap[give] ?: 0) + 1
            takeMap[take] = (takeMap[take] ?: 0) + 1
            whoGiveMap[give]?.add(take)
        }

        val giftRecord = mutableMapOf<String, Int>()
        giveMap.forEach { (friend, giveCount) ->
            giftRecord[friend] = giveCount - (takeMap[friend] ?: 0)
        }

        val receivedGifts = mutableMapOf<String, Int>()

        friends.forEach { friend1 ->
            friends.forEach { friend2 ->
                if (friend1 != friend2) {
                    val giveToOther = whoGiveMap[friend1]?.count { it == friend2 } ?: 0
                    val giveToMe = whoGiveMap[friend2]?.count { it == friend1 } ?: 0

                    if (giveToOther > giveToMe) {
                        receivedGifts[friend1] = (receivedGifts[friend1] ?: 0) + 1
                    } else if (giveToOther == giveToMe) {
                        val giftIndex1 = giftRecord[friend1] ?: 0
                        val giftIndex2 = giftRecord[friend2] ?: 0

                        if (giftIndex1 > giftIndex2) {
                            receivedGifts[friend1] = (receivedGifts[friend1] ?: 0) + 1
                        }
                    }
                }
            }
        }

        return receivedGifts.values.maxOrNull() ?: 0
    }
}

fun main() {
    `가장 많이 받은 선물`().solution(
        arrayOf("muzi", "ryan", "frodo", "neo"),
        arrayOf("muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"))
}