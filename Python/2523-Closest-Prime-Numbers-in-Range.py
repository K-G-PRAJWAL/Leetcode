class Solution:
    def closestPrimes(self, l: int, r: int) -> List[int]:


        def sieve():
            is_prime = [True] * (r+1)
            is_prime[0] = is_prime[1] = False

            for n in range(2, int(sqrt(r+1))+1):
                if not is_prime[n]:
                    continue
                for m in range(n + n, r + 1, n):
                    is_prime[m] = False
            primes = []
            for i in range(len(is_prime)):
                if is_prime[i] and i>=l:
                    primes.append(i)
            return primes

        primes = sieve()
        ans = [-1, -1]
        diff = r - l + 1
        for i in range(1, len(primes)):
            if primes[i] - primes[i-1] < diff:
                diff = primes[i] - primes[i-1]
                ans = [primes[i-1], primes[i]]
        return ans