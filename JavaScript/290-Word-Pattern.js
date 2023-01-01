/**
 * @param {string} pattern
 * @param {string} s
 * @return {boolean}
 */
var wordPattern = function (pattern, s) {
    var words = s.split(" ")
    var map = new Map()
    if ((words.length !== pattern.length)) return false
    if (new Set(words).size !== new Set(pattern).size) return false

    for (var i = 0; i < words.length; i++) {
        var ch = pattern.charAt(i)
        var w = words[i]
        if (ch in map) {
            if (map[ch] != w) return false
        } else
            map[ch] = w;
    }
    return true
};

console.log(wordPattern("abba", "dog cat cat dog"))