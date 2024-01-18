/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n, dp = new Array()) {
  if (n == 1) return 1;
  if (n == 2) return 2;
  if (dp[n] != undefined) return dp[n];
  dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
  return dp[n];
};
