## Problem 17: Longest Unique API Token Substring
# Difficulty: Medium
# Pattern 17: String Sliding Window
# Problem Statement:
# You are writing a security scanner that parses a raw communication string s. You need to find the length of the longest substring that contains completely unique characters (no duplicate characters allowed).
# Example 1:

# * Input: s = "abcabcbb"
# * Output: 3
# * Explanation: The longest valid unique character substring is "abc", which has a length of 3.

# Example 2:

# * Input: s = "bbbbb"
# * Output: 1
# * Explanation: The answer is "b", with a length of 1.

# Example 3:

# * Input: s = "pwwkew"
# * Output: 3
# * Explanation: The answer is "wke", with a length of 3. Note that the answer must be a substring ("pwke" is a subsequence, not a substring).

# Constraints:

# * 0 <= s.length <= 5 * 10⁴
# * s consists of English letters, digits, symbols, and spaces.

def unique_substring(str):
    lookup = {}
    left = 0
    max_len = 0
    for right, v in enumerate(str):
        if v in lookup and lookup[v] >= left:
            left = lookup[v] + 1
            right += 1
        lookup[v] = right
        max_len = max(max_len, right - left + 1)
    return max_len

print(unique_substring("abcad"))
print(unique_substring("abcdact"))
print(unique_substring("tmmzuxt"))

