/**
 * @param {string} word
 * @param {string[]} forbidden
 * @return {number}
 */

/*
Time Complexity: O(n * k + mk)
Space Complexity: O(mk)
*/
class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  add(word) {
    let node = this.root;
    for (let i = 0; i < word.length; i++) {
      node = node.children;
      let char = word[i];
      if (!node[char]) node[char] = new TrieNode();
      node = node[char];
      node.count++;
    }
    node.wordEnd = true;
  }
}

class TrieNode {
  constructor() {
    this.children = {};
    this.count = 0;
    this.wordEnd = false;
  }
}

var longestValidSubstring = function (word, forbidden) {
  const n = word.length;

  let trie = new Trie();

  for (let i = 0; i < forbidden.length; i++) trie.add(forbidden[i]);

  let r = n - 1;
  let ans = 0;

  for (let l = n - 1; l >= 0; l--) {
    let node = trie.root;
    let i = l;

    while (node) {
      node = node.children;
      if (!node[word[i]]) break;
      node = node[word[i]];
      if (node.wordEnd) {
        r = Math.min(r, i - 1);
        break;
      }
      i++;
    }

    ans = Math.max(ans, r - l + 1);
  }
  return ans;
};
