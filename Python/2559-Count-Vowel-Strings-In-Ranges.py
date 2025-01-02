class Solution:
    def vowelStrings(self, words: List[str], queries: List[List[int]]) -> List[int]:
        n_words = len(words)
        n_queries = len(queries)

        vowels = {'a', 'e', 'i', 'o', 'u'}
        prefix_sum = [0] * n_words
        cnt = 0

        for i in range(n_words):
            curr = words[i]
            if curr[0] in vowels and curr[-1] in vowels:
                cnt += 1
            prefix_sum[i] = cnt

        ans = [0]*n_queries
        for i in range(n_queries):
            curr = queries[i]
            ans[i] = prefix_sum[curr[1]]-(0 if curr[0]==0 else prefix_sum[curr[0]-1])

        return ans

