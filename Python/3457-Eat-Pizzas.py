class Solution:
    def maxWeight(self, pizzas: List[int]) -> int:
        days = len(pizzas) // 4

        odd_count = (days + 1) // 2
        even_count = days // 2

        pizzas_considered = odd_count + 2 * even_count
        sorted_pizzas = sorted(pizzas, reverse=True)
        total = sum(sorted_pizzas[:odd_count])

        for i in range(odd_count + 1, pizzas_considered, 2):
            total += sorted_pizzas[i]

        return total