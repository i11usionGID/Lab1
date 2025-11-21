package ru.lab

fun main() {
    val reshala = Reshala()
    println(reshala.climbStairs(5) == 8)
    println(reshala.jump(intArrayOf(1, 2, 3)) == 2)
    println(reshala.getRow(5) == listOf(1, 5, 10, 10, 5, 1))
    println(reshala.maxProfit1(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    println(reshala.maxProfit2(intArrayOf(1,2,3,4,5)) == 4)
}

class Reshala() {

    //1.Climbing Stairs
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        var prev1 = 1
        var prev2 = 2
        for(i in 3..n) {
            var current = prev1 + prev2
            prev1 = prev2
            prev2 = current
        }
        return prev2
    }

    //2.Jumping Game 2.
    fun jump(nums: IntArray): Int {
        val n = nums.size
        if (n <= 1) return 0
        var jumps = 0
        var currentEnd = 0
        var farthest = 0
        for (i in 0 until n - 1) {
            farthest = maxOf(farthest, i + nums[i])
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest

                if (currentEnd >= n - 1) break
            }
        }
        return jumps
    }

    //3.Pascal’s Triangle 2.
    fun getRow(rowIndex: Int): List<Int> {
        val row = MutableList(rowIndex + 1) { 1 }
        for (i in 1 until rowIndex) {
            row[i] = (row[i - 1].toLong() * (rowIndex - i + 1) / i).toInt()
        }
        return row
    }

    //4.Best time to buy and sell stock 1.
    fun maxProfit1(prices: IntArray): Int {
        var minBuy = Int.MAX_VALUE
        var maxProfit = 0
        for (price in prices) {
            if (price < minBuy) {
                minBuy = price
            } else {
                maxProfit = maxOf(maxProfit, price - minBuy)
            }
        }
        return maxProfit
    }

    //5.Best time to buy and sell stock 2.
    fun maxProfit2(prices: IntArray): Int {
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }
}