package edu.yuranich.codeforces.kotlinheroes

fun main(args: Array<String>) {
    val n = readLine()?.toInt() ?: throw IllegalArgumentException("empty input")
    val str = readLine() ?: throw IllegalArgumentException("empty input")
    val numbers = str.split(" ").map { it.toInt() }.zip(1 .. n)
//    println(numbers)
    val sorted = numbers.sortedBy { it.first }
    val first = sorted[0]
    val second = sorted.firstOrNull { it.first > first.first }
    if (second == null) {
        println("-1 -1 -1")
        return
    }
    val third = sorted.firstOrNull { it.first > second.first }
    if (third == null) {
        println("-1 -1 -1")
        return
    }
    println("${first.second} ${second.second} ${third.second}")
}
