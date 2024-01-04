/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function (nums) {
  const counter = new Map();
  for (const n of nums) counter.set(n, (counter.get(n) || 0) + 1);

  let ans = 0;
  for (const val of counter.values()) {
    if (val == 1) return -1;
    ans += Math.ceil(val / 3);
  }

  return ans;
};
