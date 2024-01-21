/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  let dp = [];

  let helper = function (i) {
    if (i >= nums.length) return 0;
    if (dp[i] != null) return dp[i];

    dp[i] = Math.max(helper(i + 2) + nums[i], helper(i + 1));
    return dp[i];
  };
  return helper(0);
};
