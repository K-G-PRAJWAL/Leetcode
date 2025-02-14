class ProductOfNumbers:

    def __init__(self):
        self.prefix = [1]
        self.n = 0

    def add(self, num: int) -> None:
        if num == 0:
            self.prefix = [1]
            self.n = 0
        else:
            self.prefix.append(self.prefix[self.n]*num)
            self.n += 1

    def getProduct(self, k: int) -> int:
        if k > self.n:
            return 0
        return (self.prefix[self.n] // self.prefix[self.n - k])

# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)