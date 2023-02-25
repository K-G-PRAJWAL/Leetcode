/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    var l = 0
    var r = 1
    var ans = 0

    while (r < prices.length) {
        if (prices[l] < prices[r]) {
            var profit = prices[r] - prices[l]
            ans = Math.max(ans, profit)
        } else {
            l = r
        }
        r += 1
    }

    return ans
};