/**
 * @param {number[]} startTime
 * @param {number[]} endTime
 * @param {number[]} profit
 * @return {number}
 */

/*
var binarySearch = function (jobs, idx) {
  let start = 0,
    end = idx - 1;
  while (start <= end) {
    let mid = Math.floor(start + (end - start) / 2);
    if (jobs[mid][1] <= jobs[idx][0]) {
      if (jobs[mid + 1][1] <= jobs[idx][0]) start = mid + 1;
      else return mid;
    } else end = mid - 1;
  }
  return -1;
};

var jobScheduling = function (startTime, endTime, profit) {
  let n = startTime.length;

  let jobs = startTime.map((start, i) => [start, endTime[i], profit[i]]);

  jobs.sort((a, b) => a[1] - b[1]);

  let dp = new Array(n);
  dp[0] = jobs[0][2];

  for (let i = 1; i < n; i++) {
    let prof = jobs[i][2];
    let x = binarySearch(jobs, i);
    if (x != -1) prof += dp[x];
    dp[i] = Math.max(prof, dp[i - 1]);
  }

  return dp[n - 1];
};
*/

var binarySearch = function (jobs, i, target) {
  let l = 0;
  let h = i;

  while (l < h) {
    let mid = Math.floor((l + h) / 2);
    if (jobs[mid][1] <= target) l = mid + 1;
    else h = mid;
  }

  return l;
};

var jobScheduling = function (startTime, endTime, profit) {
  const n = startTime.length;
  const jobs = new Array(n);

  for (let i = 0; i < n; i++) jobs[i] = [startTime[i], endTime[i], profit[i]];

  jobs.sort((a, b) => a[1] - b[1]);

  const dp = new Array(n + 1).fill(0);

  for (let i = 0; i < n; i++) {
    const [start, end, profit] = jobs[i];
    let j = binarySearch(jobs, i, start);
    dp[i + 1] = Math.max(dp[i], dp[j] + profit);
  }

  return dp[n];
};
