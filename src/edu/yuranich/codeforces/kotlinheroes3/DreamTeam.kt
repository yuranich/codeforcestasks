package edu.yuranich.codeforces.kotlinheroes3

import java.lang.Math.abs

fun main(args: Array<String>) {
    val t = readInt()
    for (i in 1..t) {
        val n = readInt()
        var team = mutableMapOf<Int, Int>()
        val chars = (1..n).zip(readInts())
        chars.filter { it.first > 0 }.toMap(team)
        val min = chars.filter { it.first != 0 }.minBy { abs(it.second) }
        if (min != null) {
            if (min.second > 0) {
                team.remove(min.first)
            } else {
                team.put(min.first, min.second)
            }
        }
        if (team.isNotEmpty()) {
            println(team.values.sum() )
            println((1..n).map { if (team.containsKey(it)) 1 else 0 }.joinToString(""))
        } else {
            println(0)
            println(0)
        }
    }
}


private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
