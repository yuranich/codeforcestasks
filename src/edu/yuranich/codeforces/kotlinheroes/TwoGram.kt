package edu.yuranich.codeforces.kotlinheroes

fun main(args: Array<String>) {
    val n = readLine()?.toInt() ?: throw IllegalArgumentException("empty input")
    val str = readLine() ?: throw IllegalArgumentException("empty input")
    val max = (0 until n-1).map { (it to twoGrams(str[it], str[it + 1], str)) }.maxBy { it.second } ?: (0 to 0)
    println("${str[max.first]}${str[max.first+1]}")
}

fun twoGrams(first: Char, second: Char, str: String): Int {
    return (0 until str.length - 1).count { str[it] == first && str[it + 1] == second }
}
