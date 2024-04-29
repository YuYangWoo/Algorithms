package 렛코드

fun main() {
    println(longestCommonPrefix(arrayOf("cir","car")))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var current = strs[0]
    for (i in 0..strs.size-2) {
        current = current.commonPrefixWith(strs[i+1])
    }
    return current

}