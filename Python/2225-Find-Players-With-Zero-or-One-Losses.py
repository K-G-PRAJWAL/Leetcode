class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        map = {}

        for winner, loser in matches:
            map[winner] = map.get(winner, 0)
            map[loser] = map.get(loser, 0) + 1

        winners = [i for i in map if map[i] == 0]
        losers = [i for i in map if map[i] == 1]

        return [sorted(winners), sorted(losers)]
