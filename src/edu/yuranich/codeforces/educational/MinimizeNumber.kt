package edu.yuranich.codeforces.educational

import java.lang.Integer.max

/**
 * Important features:
 * 1) Can change only neighbours
 * 2) Can change only with different parity
 * 3) Start from different positions can lead to different results
 * 4) The order of digits with the same parity will never change
 */
fun main(args: Array<String>) {
    val t = readInt()
    for (i in 1..t) {
        val a = readLn()
        println(minimize(a))
    }
}

fun minimize(x: String): String {
    val evens = x.map { it.toString().toInt() }.filter { it % 2 == 0 }
    val eSize = evens.size
    val odds = x.map { it.toString().toInt() }.filter { it % 2 == 1 }
    val oSize = odds.size
    var posEven = 0
    var posOdd = 0
    val res = mutableListOf<Int>()
    while (posEven < eSize || posOdd < oSize) {
        if (posEven >= eSize) {
            res.add(odds[posOdd])
            posOdd++
        } else if (posOdd >= oSize) {
            res.add(evens[posEven])
            posEven++
        } else if (evens[posEven] < odds[posOdd]) {
            res.add(evens[posEven])
            posEven++
        } else {
            res.add(odds[posOdd])
            posOdd++
        }
    }
    return res.joinToString("")
}

private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
