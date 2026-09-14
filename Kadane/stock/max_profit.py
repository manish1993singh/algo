
# * Input: changes = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
# * Output: 6
# * Explanation: The contiguous day sequence [4, -1, 2, 1] has the largest cumulative sum of 6.


def find_profit_streak(arr):
    max_profit = 0
    running_max = 0
    for p in arr:
        running_max = max(p, running_max+p)
        max_profit = max(max_profit, running_max)
    return max_profit

print(find_profit_streak([-2, 1, -3, 4, -1, 2, 1, -5, 4]))

print(find_profit_streak([-5, -2, -3]))

print(find_profit_streak([1]))