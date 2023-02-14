/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function (a, b) {
    let carry = 0
    let ans = []

    let n1 = a.length - 1
    let n2 = b.length - 1

    while (n1 >= 0 || n2 >= 0) {
        let sum = carry
        if (n1 >= 0) sum += a[n1--].charCodeAt() - 48
        console.log(sum)
        if (n2 >= 0) sum += b[n2--].charCodeAt() - 48
        console.log(sum)
        ans.unshift(sum % 2)
        carry = ~~(sum / 2)
    }
    return carry > 0 ? "1" + ans.join("") : ans.join("")
};