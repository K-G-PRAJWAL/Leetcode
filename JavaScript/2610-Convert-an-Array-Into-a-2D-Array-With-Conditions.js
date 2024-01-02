/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findMatrix = function(nums) {
    const freq = new Array(nums.length+1).fill(0)
    const ans = []

    for(const n of nums) {
        if(freq[n] >= ans.length) {
            ans.push([])
        }

        ans[freq[n]].push(n)
        freq[n]++
    }

    return ans
};