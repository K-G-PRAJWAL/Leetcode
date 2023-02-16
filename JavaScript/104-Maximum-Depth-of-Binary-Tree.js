/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function (root) {
    if (!root) return 0
    return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1)
};


var maxDepth = function (root) {
    ans = 0
    if (root) {
        lvl = [root]
    } else lvl = []

    while (lvl.length > 0) {
        ans += 1
        queue = []
        for (var i = 0; i < lvl.length; i++) {
            if (lvl[i].left) queue.push(lvl[i].left)
            if (lvl[i].right) queue.push(lvl[i].right)
        }
        lvl = queue
    }
    return ans
};