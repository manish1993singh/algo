## Problem 13: Sorting Data Centers
# Difficulty: Medium
# Pattern 13: Dutch National Flag (3-way partition)
# Problem Statement:
# You are managing an operations dashboard where incoming server logs are categorized by priority level: 0 (Low Priority), 1 (Medium Priority), and 2 (High Priority). You receive an array logs containing these values in an unsorted order.
# Sort the array in-place so that logs of the same priority are grouped together, with the priorities in ascending order (0s, then 1s, then 2s).
# You must solve this problem without using your language's built-in sort function and using only $O(1)$ extra space in a single pass.
# Example 1:

# * Input: logs = [2, 0, 2, 1, 1, 0]
# * Output: [0, 0, 1, 1, 2, 2]

# Example 2:

# * Input: logs = [2, 0, 1]
# * Output: [0, 1, 2]

# Constraints:

# * 1 <= logs.length <= 300
# * logs[i] is either 0, 1, or 2.


def partition(arr):
    counter_0 = 0
    counter_1 = 0
    counter_2 = 0
    for v in arr:
        if v == 0:
            counter_0 += 1
        elif v == 1:
            counter_1 += 1
        else:
            counter_2 += 1
    result = [0]*counter_0 
    result.extend([1]*counter_1)
    result.extend([2]*counter_2)
    return result

def partition_2(arr):
    low = 0
    mid = 0
    high = len(arr) - 1

    while mid <= high:
        if arr[mid] == 0:
            arr[low], arr[mid] = arr[mid], arr[low]
            low += 1
            mid += 1
        elif arr[mid] == 1:
            mid += 1
        else:  # arr[mid] == 2
            arr[mid], arr[high] = arr[high], arr[mid]
            high -= 1
    return arr

print(partition([2, 0, 2, 1, 1, 0]))
print(partition_2([2, 0, 2, 1, 1, 1]))
    
            
