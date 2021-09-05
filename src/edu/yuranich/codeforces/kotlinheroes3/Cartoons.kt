package edu.yuranich.codeforces.kotlinheroes3

fun main(args: Array<String>) {
    val t = readInt()
    for (i in 1..t) {
        val n = readInt()
        val periods = (1 .. n).map {
            val (a, b) = readInts()
            (a to b)
        }
        println(findDay(periods))
    }
}

private fun findDay(periods: List<Pair<Int, Int>>): Int {
    for ((a, b) in periods) {
        periods.groupBy { it.first <= b || it.second >= a }
    }
    val min = periods.minBy { it.first }?.first ?: 0
    val max = periods.maxBy { it.second }?.second ?: 1_000_000_000
    val med = min + max / 2
    for (day in (min .. max)) {
        val count = periods.count { it.first <= day && it.second >= day }
        if (count == 1) return day
    }
    return -1
}

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
