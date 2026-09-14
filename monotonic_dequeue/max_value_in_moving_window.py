## Problem 25: Max Value in Moving Broadcast Window
# Difficulty: Hard
# Pattern 25: Monotonic Deque (Window max/min tracking)
# Problem Statement:
# You are building a real-time analytics window monitoring memory loads. 
# You are given an array of integers nums, and a sliding window of size k which is moving from the very 
# left of the array to the very right. You can only see the k numbers in the window at any one time.
# Each time the sliding window moves right by one position, it drops an element from the left and gains a new one on the right.
# Return an array containing the maximum element observed inside the window at each boundary shift.
# Example 1:

# * Input: nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
# * Output: [3, 3, 5, 5, 6, 7]
# * Explanation:
# Window position | Max
# ------------------------- | -----
# [1, 3, -1] -3 5 3 6 7 | 3
# 1 [3, -1, -3] 5 3 6 7 | 3
# 1 3 [-1, -3, 5] 3 6 7 | 5
# 1 3 -1 [-3, 5, 3] 6 7 | 5
# 1 3 -1 -3 [5, 3, 6] 7 | 6
# 1 3 -1 -3 5 [3, 6, 7] | 7

# Example 2:

# * Input: nums =, k = 1
# * Output: 1

# Constraints:

# * 1 <= nums.length <= 10⁵
# * -10⁴ <= nums[i] <= 10⁴
# * 1 <= k <= nums.length

from collections import deque
def max_in_window(arr:list[int], k:int) -> list[int]:
    dq = deque()
 
    result = [0]*(len(arr)- k + 1)

    for i in range(len(arr)):
        v = arr[i]
        print(f"dq:{dq}, i:{i}")
        if dq and dq[0] < i - k + 1:
            dq.popleft()
        while dq and arr[dq[-1]] < v:
            dq.pop()
        dq.append(i)
        if i + 1 >= k:
            result[i + 1 - k] = arr[dq[0]]
    return result

print(max_in_window([1, 3, -1, -3, 5, 3, 6, 7], 3))
