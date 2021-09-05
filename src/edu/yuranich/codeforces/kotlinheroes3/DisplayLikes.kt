package edu.yuranich.codeforces.kotlinheroes3

//import kotlin.math.round

fun main(args: Array<String>) {
    val t = readInt()
    for (i in 1..t) {
        val n = readInt()
        val likes = roundNumber(n)
        println(likes)
    }
}

private fun roundNumber(n: Int): String {
    if (n > 999_499) {
        return "${Math.round( n / 1_000_000.0).toInt()}M"
    } else if (n > 999) {
        return "${Math.round( n / 1_000.0).toInt()}K"
    }
    return "$n"
}

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
