## Problem 28: K-th Highest Server Request Frequency
# Difficulty: Medium
# Pattern 28: Min/Max Heap (Top K / Dynamic Ordering)
# Problem Statement:
# You are building an edge-router stream filtering tool. Given an unsorted integer array nums representing packet log sizes 
# and an integer k, return the k-th largest element in the array.
# Note that it is the k-th largest element in the sorted order, not the k-th distinct element.
# You must solve this problem in an optimized O(N log K) time complexity rather than a full O(N log N) sort.
# Example 1:

# * Input: nums = [3, 2, 1, 5, 6, 4], k = 2
# * Output: 5
# * Explanation: The sorted order would be [1, 2, 3, 4, 5, 6]. The 2nd largest element is 5.

# Example 2:

# * Input: nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
# * Output: 4

# Constraints:

# * 1 <= k <= nums.length <= 10⁵
# * -10⁴ <= nums[i] <= 10⁴
import heapq
def kth_largest(arr, k):
    return heapq.nlargest(k, arr)[-1]

print(kth_largest([3, 2, 1, 5, 6, 4], 2))