package edu.yuranich.codeforces.educational

/**
 * Important conditions:
 * 1) n is odd
 * 2) l1 + l2 + ... + ln =< s
 * 3) maximize median salary
 * 4) result is not greater than median[r1,...,rn]
 */
fun main(args: Array<String>) {
    val t = readInt()
    for (i in 1..t) {
        val (n, s) = readLongs()
        val bounds = (1..n).map {
            val (l, r) = readLongs()
            if (r < l) throw IllegalArgumentException("r mustn't be less than l")
            l to r
        }.sortedBy { it.second }
//        println("bounds: $bounds")
        val result = computeMedian(bounds, n.toInt(), s)
        println(result)
    }

}

fun computeMedian(bounds: List<Pair<Long, Long>>, n: Int, s: Long): Long {
    val medIndex = n / 2
    val maxRes = bounds[medIndex].second
    // can we achieve it?
    var curMax = maxRes.coerceAtMost(s)
    val sortedByL = bounds.sortedBy { it.first }
    val minRes = sortedByL[medIndex].first
    var curMin = minRes
    while (curMax - curMin > 1) {
        val mid = (curMax + curMin) / 2
        val required = requiredSum(sortedByL, mid, medIndex)
        //        println("Required: $required")

        if (required > s) {
            curMax = mid
        } else {
            curMin = mid
        }
    }
    return if (requiredSum(sortedByL, curMax, medIndex) > s) curMin else curMax
}

private fun requiredSum(
    sortedByL: List<Pair<Long, Long>>,
    mid: Long,
    medIndex: Int
): Long {
    val lowerBound = sortedByL.filter { it.second < mid }.map { it.first }
    val upperBound = sortedByL.filter { it.first >= mid }.map { it.first }
    val midBound = sortedByL.filter { it.first < mid && mid <= it.second }

    val lSum = lowerBound.sum()
    val uSum = upperBound.sum()
    val (mlSum, midSum) = if (upperBound.size <= medIndex) {
        midBound.subList(0, medIndex - lowerBound.size).map { it.first }.sum() to mid * (medIndex + 1 - upperBound.size)
    } else 0L to 0L

    return lSum + uSum + mlSum + midSum
}


private fun readLn() = readLine()!! // string line
private fun readInt() = readLn().toInt() // single int
private fun readStrings() = readLn().split(" ") // list of strings
private fun readInts() = readStrings().map { it.toInt() } // list of ints
private fun readLongs() = readStrings().map { it.toLong() } // list of longs
