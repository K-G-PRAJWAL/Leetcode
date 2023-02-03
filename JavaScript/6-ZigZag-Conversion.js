/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
    if (numRows === 1) return s

    ans = ""
    for (var row = 0; row < numRows; row++) {
        var increment = 2 * (numRows - 1)
        for (var i = row; i < s.length; i += increment) {
            ans += s[i]
            if (row > 0 && row < numRows - 1 && i + increment - 2 * row < s.length) {
                ans += s[i + increment - 2 * row]
            }
        }
    }

    return ans
};