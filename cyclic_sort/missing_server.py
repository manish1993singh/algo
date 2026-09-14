## Problem 14: Finding the Defective Server ID
# Difficulty: Easy
# Pattern 14: Cyclic Sort (Values in [1, n] / Index Mapping)
# Problem Statement:
# You manage a cluster of n servers labeled uniquely from 1 to n. You are given an array servers containing n integers. Because of a configuration error, one server ID was duplicated, which caused another server ID to go missing entirely from the cluster.
# Find and return the identity of the duplicate server and the missing server as an array [duplicate, missing].
# You must solve this problem in-place without using extra space (i.e., O(1) auxiliary space).
# Example 1:

# * Input: servers = [1, 2, 2, 4]
# * Output: [2, 3]
# * Explanation: 2 appears twice, and 3 is missing from the [1, 4] range.

# Example 2:

# * Input: servers = [3, 1, 2, 5, 2]
# * Output: [2, 4]

# Constraints:

# * n == servers.length
# * 2 <= n <= 10⁴
# * 1 <= servers[i] <= n

def cyclic_sort(arr):
    i = 0
    while i < len(arr):
        corrected_inded = arr[i] - 1
        if arr[i] != arr[corrected_inded]:
            arr[i], arr[corrected_inded] = arr[corrected_inded], arr[i]
        else:
            i += 1
    return arr

def missing_server(arr):
    arr = cyclic_sort(arr)
    for i, v in enumerate(arr):
        if i+1 != v:
            return [v, i+1]




print(missing_server([3,1,2,5,2]))
print(missing_server([1,2,2,4]))
    