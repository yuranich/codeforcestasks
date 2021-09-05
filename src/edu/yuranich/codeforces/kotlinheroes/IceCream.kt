package edu.yuranich.codeforces.kotlinheroes

fun main(args: Array<String>) {
    val line = readLine() ?: throw IllegalArgumentException("empty input")
    val (n, k) = line.split(" ").map { it.trim().toLong() }
//    println("n = $n k = $k")
    val days = (1 .. n).map {
        val l = readLine() ?: throw IllegalArgumentException("empty input")
        val (a, b, c) = l.split(" ").map { it.toLong() }
        Triple(a, b, c)
    }
//    println(days.joinToString("\n"))
    val totalA: Long = days.foldRight(0L) { tr, acc -> acc + tr.first }
    if (totalA > k) {
        println("-1")
        return
    }
    val totalB: Long = days.foldRight(0L) { tr, acc -> acc + tr.second }
    if (totalB < k) {
        println("-1")
        return
    }
    var totalC: Long = days.fold(0L) { acc: Long, tr: Triple<Long, Long, Long> ->  acc + tr.first * tr.third }
//    println("C = $totalC")
    var left = k - totalA
//    println("left = $left")
    val greedyDays = days.sortedBy { it.third }
    var index = 0
    while (left > 0) {
        val cur = greedyDays[index]
        val diff = cur.second - cur.first
        if (diff >= left) {
            totalC += left * cur.third
            break
        } else {
            totalC += diff * cur.third
            index++
            left -= diff
        }
    }
    println(totalC)
}
