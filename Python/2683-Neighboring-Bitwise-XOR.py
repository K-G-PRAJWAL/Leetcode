class Solution:
    def doesValidArrayExist(self, derived: List[int]) -> bool:
        # Approach 1
        n = len(derived)

        original = [0]
        for i in range(n):
            original.append(derived[i] ^ original[i])

        zero = original[0] == original[-1]

        original = [1]
        for i in range(n):
            original.append(derived[i] ^ original[i])

        one = original[0] == original[-1]

        return zero or one

        # Approach 2
        xor = 0

        for n in derived:
            xor ^= n

        return xor == 0

        # Approach 3
        return sum(derived)%2==0