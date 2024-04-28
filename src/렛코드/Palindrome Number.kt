package 렛코드

fun main() {
    isPalindrome(121)
}

fun isPalindrome(x: Int): Boolean {
    return x.toString() == x.toString().reversed()
}