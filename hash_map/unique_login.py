## Problem 15: Tracking Unique Visitor Logins
# Difficulty: Easy
# Pattern 15: HashMap / HashSet
# Problem Statement:
# You are building an analytics dashboard for an application. You are given an array of integers visitor_ids, where each integer represents the unique ID of a user logging into the system during a specific hour.
# You need to verify if any user has logged in more than once during this period. Return true if any visitor ID appears at least twice in the array, and return false if every element is distinct.
# Example 1:

# * Input: visitor_ids = [1, 2, 3, 1]
# * Output: true

# Example 2:

# * Input: visitor_ids = [1, 2, 3, 4]
# * Output: false

# Constraints:

# * 1 <= visitor_ids.length <= 10⁵
# * -10⁹ <= visitor_ids[i] <= 10⁹


def has_loggedin(arr):
    seen = set()

    for v in arr:
        if v in seen:
            return True
        seen.add(v)

    return False


# Example 1
print(has_loggedin([1, 2, 3, 1]))  # True

# Example 2
print(has_loggedin([1, 2, 3, 4]))  # False

# Example 3
print(has_loggedin([5, 5, 5]))  # True