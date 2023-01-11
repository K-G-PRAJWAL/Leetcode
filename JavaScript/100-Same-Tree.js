class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val
        this.lfet = left
        this.right = right
    }
}

var isSameTree = function (p, q) {
    if (!p && !q) return true
    if (!p || !q) return false
    if (p.val !== q.val) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
};