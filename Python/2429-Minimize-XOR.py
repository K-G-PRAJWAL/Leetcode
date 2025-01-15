class Solution:
    def _is_set(self, x, bit):
        return (x & (1 << bit)) != 0

    def _set_bit(self, x, bit):
        return (x | (1 << bit))

    def _unset_bit(self, x, bit):
        return (x & ~(1 << bit))

    def minimizeXor(self, num1: int, num2: int) -> int:
        ans = num1

        req_set_bits = bin(num2).count('1')
        set_bits = bin(ans).count('1')

        curr = 0

        while set_bits < req_set_bits:
            if not self._is_set(ans, curr):
                ans = self._set_bit(ans, curr)
                set_bits += 1
            curr += 1

        while set_bits > req_set_bits:
            if self._is_set(ans, curr):
                ans = self._unset_bit(ans, curr)
                set_bits -= 1
            curr += 1

        return ans

    def minimizeXor_2(self, num1: int, num2: int) -> int:
        ans = 0

        req_set_bits = bin(num2).count('1')
        set_bits = 0
        curr = 31

        while set_bits < req_set_bits:
            if self._is_set(num1, curr) or (req_set_bits - set_bits > curr):
                ans = self._set_bit(ans, curr)
                set_bits += 1
            curr -= 1
        return ans