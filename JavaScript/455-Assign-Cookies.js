/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g.sort((a, b) => a - b);
    s.sort((a, b) => a - b);

    let gIdx = 0, sIdx = 0, cnt = 0;

    while (gIdx < g.length && sIdx < s.length) {
        if(g[gIdx] <= s[sIdx]) {
            gIdx++;
            sIdx++;
            cnt++;
        } else sIdx++;
    }
    return cnt;
};