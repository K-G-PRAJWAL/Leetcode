/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */

var fn_1 = function (s1, s2, i, j, dp) {
    if (i < 0) return j + 1
    if (j < 0) return i + 1
    if (dp[i][j] != -1) return dp[i][j]
    if (s1[i] == s2[j]) return fn_1(s1, s2, i - 1, j - 1, dp)
    return dp[i][j] = 1 + Math.min(fn_1(s1, s2, i - 1, j, dp), Math.min(fn_1(s1, s2, i, j - 1, dp), fn_1(s1, s2, i - 1, j - 1, dp)))
}

var fn_2 = function (s1, s2, i, j, dp) {
    if (i == 0) return j
    if (j == 0) return i
    if (dp[i][j] != -1) return dp[i][j]
    if (s1[i - 1] == s2[j - 1]) return dp[i][j] = fn_2(s1, s2, i - 1, j - 1, dp)
    return dp[i][j] = 1 + Math.min(fn_2(s1, s2, i - 1, j, dp), Math.min(fn_2(s1, s2, i, j - 1, dp), fn_2(s1, s2, i - 1, j - 1, dp)))
}

var minDistance = function (word1, word2) {
    var n = word1.length
    var m = word2.length
    var dp = new Array(n + 1).fill(-1).map(() => new Array(m + 1).fill(-1));
    return fn_2(word1, word2, n, m, dp)
};