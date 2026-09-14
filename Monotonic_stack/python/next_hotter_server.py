# Problem 21: Next Warmer Server 
# MetricDifficulty: MediumPattern 
# 21: Monotonic Stack (Next greater/smaller element)
# Problem Statement:You are building an automated load balancer monitoring tool. You are given an array of integers temperatures representing the daily core temperature of a main server rack.
# Return an array answer such that answer[i] is the number of days you have to wait after the i-th day to get 
# a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
# Example 1:
# Input: temperatures = [73, 74, 75, 71, 69, 72, 76, 73]
# Output: [1, 1, 4, 2, 1, 1, 0, 0]
# Explanation:Day 0 (73) waits 1 day to see 74.Day 2 (75) waits 4 days to see 76.Day 6 (76) has no hotter day ahead, so it gets 0.Example 2:Input: temperatures = [30, 40, 50, 60]Output: [1, 1, 1, 0]
# Constraints:1 <= temperatures.length <= 10⁵
# 30 <= temperatures[i] <= 100


def next_hot(arr:list[int]) -> list[int]:
    result = [0]*len(arr)
    stack = []
    for i, v in enumerate(arr):
        while len(stack) > 0 and  arr[stack[-1]] < v:
            popped = stack.pop()
            result[popped] = i - popped

        stack.append(i)
    return result

print(next_hot([73, 74, 75, 71, 69, 72, 76, 73]))