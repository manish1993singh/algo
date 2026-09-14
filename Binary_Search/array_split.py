## Problem 12: Split Array into Balanced Teams
# Difficulty: Medium
# Pattern 12: Binary Search on Answer (Optimize value + feasibility check)
# Problem Statement:
# You are organizing a coding marathon with n developers standing in a fixed line. You are given an integer array skills, where skills[i] is the skill level of the i-th developer. You need to partition the line of developers into k contiguous, non-empty teams.
# The "intensity" of a team is the sum of the skills of its members. To keep the competition balanced, you want to minimize the maximum intensity among all k teams.
# Return the minimized maximum team intensity possible after making an optimal partition.
# Example 1:

# * Input: skills = [7, 2, 5, 10, 8], k = 2
# * Output: 18
# * Explanation: There are four ways to split the array into two teams:
# * [7] and [2, 5, 10, 8] → max team sum is $\max(7, 25) = 25$
#    * [7, 2] and [5, 10, 8] → max team sum is $\max(9, 23) = 23$
#    * [7, 2, 5] and [10, 8] → max team sum is $\max(14, 18) = **18**$
#    * [7, 2, 5, 10] and [8] → max team sum is $\max(24, 8) = 24$
#    The minimum possible value among all maximum intensities is 18.

# Example 2:

# * Input: skills = [1, 2, 3, 4, 5], k = 2
# * Output: 9
# * Explanation: Optimal partition is [1, 2, 3] and [4, 5]. Max sum is 9.

# Constraints:

# * 1 <= skills.length <= 10⁴
# * 1 <= skills[i] <= 10⁵
# * 1 <= k <= min(50, skills.length)


def split(arr, k):
    min_capacipty = float('inf')

    for i in range(1, len(arr)):
        left = arr[0:i]
        right = arr[i:]
        # need to improve to avoid recalculation
        local_max = max(sum(left), sum(right))
        min_capacipty = min(min_capacipty, local_max)

    return min_capacipty


#incomplete code, only works for 2 teams
def split_2(arr, k):
    min_cap = float('inf')
    left = 0
    right = sum(arr)

    for v in arr:
        left += v
        right -= v
        local_max = max(left, right)
        min_cap = min(min_cap,local_max)
    return min_cap



def split_3(arr, k):
    left = max(arr)
    right = sum(arr)
    cap = 0
    while left <= right:
        mid = left + (right - left)//2
        if(can_split(k, mid, arr)):
            right = mid - 1
            cap = mid
        else:
            left = mid + 1

    return cap



def can_split(k, cap, arr):
    teams = 1
    loc_capacity = 0
    for v in arr:
        loc_capacity += v
        if loc_capacity > cap:
            teams += 1
            loc_capacity = v
            if teams > k:
                return False

    return True



print(split([7, 2, 5, 10, 8], 2))
print(split_2([7, 2, 5, 10, 8], 2))
print(split_3([7, 2, 5, 10, 8], 2))