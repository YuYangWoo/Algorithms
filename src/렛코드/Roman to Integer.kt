package 렛코드

fun main() {
    println(romanToInt("III"))
}

fun romanToInt(s: String): Int {
    val a = s.mapIndexed { index, c ->

    }
    val map = HashMap<String, Int>().apply {
        put("I", 1)
        put("IV", 4)
        put("V", 5)
        put("IX", 9)
        put("X", 10)
        put("XL", 40)
        put("L", 50)
        put("XC", 90)
        put("C", 100)
        put("CD", 400)
        put("D", 500)
        put("CM", 900)
        put("M", 1000)
    }
    var count = 0
    var target = java.lang.StringBuilder(s)
    for (i in target.indices) {
        if ((i + 1 < target.length) && ("${target[i]}${target[i + 1]}" == "IV" || "${target[i]}${target[i + 1]}" == "IX"
                    || "${target[i]}${target[i + 1]}" == "XL" || "${target[i]}${target[i + 1]}" == "XC"
                    || "${target[i]}${target[i + 1]}" == "CD" || "${target[i]}${target[i + 1]}" == "CM")
        ) {
            val item = "${target[i]}${target[i + 1]}"
            if (map.containsKey(item)) {
                count += map[item] ?: 0
                target.setCharAt(i, 'Z')
                target.setCharAt(i + 1, 'Z')
            }
        } else {
            count += map[target[i].toString()] ?: 0
            target.setCharAt(i, 'Z')
        }
    }
    return count
}