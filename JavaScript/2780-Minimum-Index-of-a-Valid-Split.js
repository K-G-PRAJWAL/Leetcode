/**
 * @param {number[]} nums
 * @return {number}
 */
var minimumIndex = function (nums) {
  let n = nums.length;
  let set = {};
  let max = 0;
  let maxFreq = 0;

  for (let i in nums) {
    if (!set[nums[i]]) set[nums[i]] = 0;
    set[nums[i]]++;

    if (set[nums[i]] > maxFreq) {
      maxFreq = set[nums[i]];
      max = nums[i];
    }
  }

  let counter = 0;
  for (let i = 0; i < n; i++) {
    if (nums[i] == max) {
      // Initialize a counter to keep track of occurrences of the dominant element.
      counter++;
      if (counter > Math.floor(n / 2))
        // If counter becomes greater than half the length of the array (n / 2), exit the loop because there can be at most one dominant element in the array.
        break;
      if (counter * 2 > i + 1 && (maxFreq - counter) * 2 > n - 1 - i) {
        // Check if the current subarray (nums[0, ..., i]) contains more occurrences of the dominant element than the other subarray (nums[i + 1, ..., n - 1]). If this condition holds, return the current index i as the minimum index of a valid split.
        return i;
      }
    }
  }

  return -1;
};
