/**
 * @param {number} m
 * @param {number} n
 * @param {number} maxMove
 * @param {number} startRow
 * @param {number} startColumn
 * @return {number}
 */

var findPaths = function (m, n, maxMove, startRow, startColumn) {
  const M = 1000000007;

  let dp = new Array(m).fill(0).map(() => new Array(n).fill(0));
  dp[startRow][startColumn] = 1;

  let count = 0;

  for (let move = 1; move <= maxMove; move++) {
    let temp = new Array(m).fill(0).map(() => new Array(n).fill(0));
    for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
        if (i == m - 1) count = (count + dp[i][j]) % M;
        if (j == n - 1) count = (count + dp[i][j]) % M;
        if (i == 0) count = (count + dp[i][j]) % M;
        if (j == 0) count = (count + dp[i][j]) % M;
        temp[i][j] =
          ((((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M) +
            (((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) %
              M)) %
          M;
      }
    }
    dp = temp;
  }
  return count;
};
