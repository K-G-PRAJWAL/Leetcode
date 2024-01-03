/**
 * @param {string[]} bank
 * @return {number}
 */
var numberOfBeams = function(bank) {
    let ans = 0
    let prev = 0

    for (i = 0; i<bank.length; i++) {
        let curr = 0
        for(let ch of bank[i]) {
            if(ch === '1') curr++
        }

        if(curr > 0) {
            ans += curr * prev
            prev = curr
        }
    }

    return ans
};