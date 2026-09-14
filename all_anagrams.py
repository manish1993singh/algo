## Problem 18: Find All Broadcast Anagrams
# Difficulty: Medium
# Pattern 18: String Frequency Map
# Problem Statement:
# You are building an encrypted packet listener. You are given two strings, s and p. Find all the start indices of p's anagrams inside s. Return the answer as an array of integers in any order.
# An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
# Example 1:

# * Input: s = "cbaebabacd", p = "abc"
# * Output: ``
# * Explanation:
# * The substring at index 0 is "cba", which is an anagram of "abc".
#    * The substring at index 6 is "bac", which is an anagram of "abc".

# Example 2:

# * Input: s = "abab", p = "ab"
# * Output: ``
# * Explanation:
# * The substring at index 0 is "ab", which is an anagram of "ab".
#    * The substring at index 1 is "ba", which is an anagram of "ab".
#    * The substring at index 2 is "ab", which is an anagram of "ab".

# Constraints:

# * 1 <= s.length, p.length <= 3 * 10⁴
# * s and p consist of lowercase English letters.

from collections import Counter

def all_anagrams(s: str, p: str) -> list[int]:
    result = []
    frequency = Counter(p)
    window = len(p)
    running_freq = {}
    for i in range(0, len(s)):
        c = s[i]
        if i < window -1:
            running_freq[c] = running_freq.get(c, 0) + 1
            continue  
        if i >= window:
            out_c = s[i-window]
            running_freq[out_c] -= 1
            if running_freq[out_c] == 0:
                del running_freq[out_c]
        running_freq[c] = running_freq.get(c, 0) + 1
        if frequency == running_freq:
            result.append(i - window + 1)
    return result


def all_anagrams_2(s: str, p: str) -> list[int]:
    """Efficient sliding-window solution.
    Time: O(n * k), where k is the number of distinct characters in p.
    For lowercase English letters, this is effectively O(n).
    """
    if len(p) > len(s):
        return []

    need = Counter(p)
    window = Counter()
    left = 0
    result = []

    for right, ch in enumerate(s):
        window[ch] += 1

        if right - left + 1 > len(p):
            out = s[left]
            window[out] -= 1
            if window[out] == 0:
                del window[out]
            left += 1

        if right - left + 1 == len(p) and all(window.get(k, 0) == v for k, v in need.items()):
            result.append(left)

    return result


all_arguments_2 = all_anagrams_2

print(all_anagrams("cbaebabacd", "abc"))
print(all_anagrams("abab", "ab"))
print(all_anagrams_2("cbaebabacd", "abc"))
print(all_anagrams_2("abab", "ab"))
print(all_arguments_2("cbaebabacd", "abc"))
