package edu.yuranich.codeforces.kotlinheroes

fun main(args: Array<String>) {
    val line = readLine() ?: throw IllegalArgumentException("empty input")
    val (n, a, b, k) = line.split(" ").map { it.toInt() }
    val ratings = readLine()?.split(" ")?.map { it.toInt() }?.zip (1 .. n)?.sortedBy { it.first } ?: throw IllegalArgumentException("empty input")

    val diffRatings = ratings.map { it.first }.distinct().sorted()

    val resulst = diffRatings.map {
        val aMates = ratings.filter { r -> r.first == it }.size
        val teamNumA = numOfTeams(aMates, a)
        println("a = $teamNumA")
        val bMates = ratings.filter { r -> r.first == it * k }.size
        val teamNumB = numOfTeams(bMates, b)
        println("b = $teamNumB")
        teamNumA * teamNumB / 2
    }.sum()
    println(resulst)
}

fun numOfTeams(mates: Int, num: Int): Long {
    if (mates < num) return 0
    if (mates == num) return 1
    return fact(mates) / (fact(mates - num) * fact(
        num
    ))
}

fun fact(n: Int): Long {
    if (n < 2) return 1
    return (1 .. n).fold(1L) { acc, x -> acc * x}
}
