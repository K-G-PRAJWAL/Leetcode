/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
  let start = 0;
  let result = 0;
  let map = {};

  for (let end = 0; end < s.length; end++) {
    let ch = s.charAt(end);
    if (ch in map) {
      start = Math.max(start, map[ch] + 1);
    }
    map[ch] = end;
    result = Math.max(result, end - start + 1);
  }
  return result;
};

// Alternate
var lengthOfLongestSubstring = function (s) {
    let left = 0
    let result = 0
    let map = new Map()

    for(let [right, ch] of [...s].entries()) {
        if(map.has(ch)) 
            left = Math.max(left, map.get(ch)+1)
        map.set(ch, right)
        result = Math.max(result, right-left+1)
    }

    return result
  };
