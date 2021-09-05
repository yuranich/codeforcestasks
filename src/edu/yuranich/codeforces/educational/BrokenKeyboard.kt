package edu.yuranich.codeforces.educational

fun main(args: Array<String>) {
    val t = readInt()
    for (i in 1..t) {
        val line = readLn()
        val res = findCorrect(line)
        println(res)
    }
}

fun findCorrect(line: String): String {
    val chars = mutableSetOf<Char>()
    for (i in line.indices) {
        val first = line[i]
        val count = line.count { it == first }
        if (count % 2 == 1) {
            chars.add(first)
        } else {
            val cleared = line.replace("$first$first", "")
            if (cleared.indexOf(first) >= 0) {
                chars.add(first)
            }
        }
    }
    return chars.sorted().joinToString("")
}


private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
