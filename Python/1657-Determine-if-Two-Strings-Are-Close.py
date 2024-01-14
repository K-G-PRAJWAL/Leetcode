from collections import Counter


class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        n_1 = len(word1)
        n_2 = len(word2)

        if n_1 != n_2:
            return False

        if set(word1) != set(word2):
            return False

        dict_1 = Counter(word1)
        dict_2 = Counter(word2)

        arr_1 = list(dict_1.values())
        arr_2 = list(dict_2.values())

        arr_1.sort()
        arr_2.sort()

        return arr_1 == arr_2
