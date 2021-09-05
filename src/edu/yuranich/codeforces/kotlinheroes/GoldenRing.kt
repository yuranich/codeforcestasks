package edu.yuranich.codeforces.kotlinheroes

fun main(args: Array<String>) {
    val line = readLine() ?: throw IllegalArgumentException("empty input")
    val n = line.toInt()
    val selfies = readLine()?.split(" ")?.map { it.toInt() }?.zip(1 .. n) ?: throw IllegalArgumentException("empty input")

    val maxNum = selfies.maxBy { it.first }?.first ?: throw IllegalArgumentException("no max number")
    val lastMaxPair = selfies.findLast { it.first == maxNum } ?: throw IllegalArgumentException("no last")
    println((maxNum.toLong() - 1) * n.toLong() + lastMaxPair.second.toLong())
}
