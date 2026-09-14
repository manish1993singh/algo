## Problem 19: Palindromic Telemetry Windows
# Difficulty: Medium
# Pattern 19: Expand Around Center
# Problem Statement:
# You are verifying data parity segments within a string text file s. You need to find and return the longest contiguous substring in s that reads the same backward as forward (a palindrome).
# If there are multiple palindromic substrings with the same maximum length, you may return any one of them.
# Example 1:

# * Input: s = "babad"
# * Output: "bab"
# * Explanation: "aba" is also a completely valid answer.

# Example 2:

# * Input: s = "cbbd"
# * Output: "bb"

# Constraints:

# * 1 <= s.length <= 1000
# * s consists of only digits and English letters.


def get_palindroms(s:str) -> list[str]:

    result = []
    size = len(s)
    for i, c in enumerate(s):
        left = i - 1
        right = i + 1
        palindrom = None
        while left >= 0 and right < size:
            if s[left] == s[right]:
                palindrom = s[left:right+1]
            left -= 1
            right += 1
        if palindrom:
            result.append(palindrom)
    return result

print(get_palindroms("babad"))