package edu.yuranich.codeforces.educational

/**
 * Important features:
 * 1) can replace any cells inside block
 * 2) total number of 1 and 0 is constant
 * 3) if string length is even - it should contain even number of 1 and even number of 0.
 * 4) if string length is odd - it should contain odd number of whatever
 * 5) we couldn't make palindrome only if parity do not match
 */
fun main(args: Array<String>) {
    val q = readInt()
    for (i in 1..q) {
        val n = readInt()
        val strings = (1..n).map { readLn() }
        println(evalPalNum(n, strings))
    }
}

private fun evalPalNum(n: Int, strings: List<String>): Int {
    val oddLengthCount = strings.map { it.length % 2 }.sum()
    val zeroParity = strings.map { it.count { i -> i == '0' } }.sum() % 2
    val oneParity = strings.map { it.count { i -> i == '1' } }.sum() % 2
    if (oddLengthCount == 0) {
        return if (zeroParity + oneParity == 0) n else n - 1
    }
    return if ((zeroParity + oneParity) % 2 == oddLengthCount % 2) n else n - 1
}

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
