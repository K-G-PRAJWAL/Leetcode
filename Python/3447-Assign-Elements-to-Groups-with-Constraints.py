class Solution:
    def assignElements(self, groups: List[int], elements: List[int]) -> List[int]:
        map = defaultdict(list)

        for n in groups:
            if n in map:
                continue
            for i in range(1, int(n ** 0.5)+1):
                if n % i == 0:
                    map[n].append(i)
                    if n // i != i:
                        map[n].append(n // i)

        eToi = defaultdict(int)
        for i, val in enumerate(elements):
            if val not in eToi:
                eToi[val] = i

        ans = [-1] * len(groups)

        for i, n in enumerate(groups):
            divisors = map[n]
            idx = len(elements)

            for d in divisors:
                if d in eToi:
                    idx = min(idx, eToi[d])

            idx = -1 if idx == len(elements) else idx
            ans[i] = idx

        return ans