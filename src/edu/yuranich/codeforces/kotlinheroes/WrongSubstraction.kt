package edu.yuranich.codeforces.kotlinheroes

fun main(args: Array<String>) {
    val line = readLine() ?: throw IllegalArgumentException("empty input")
    val (n, k) = line.split(" ").map { it.trim().toInt() }
//    println("n = $n k = $k")
    val result = (1 .. k).fold(n) { acc, _ -> substractOne(acc) }
    println(result)
}

fun substractOne(from: Int): Int {
//    println(from)
    return if (from % 10 == 0) from / 10 else from - 1
}
