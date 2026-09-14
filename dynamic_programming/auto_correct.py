## Problem 20: Minimum Edit Blueprint
# Difficulty: Medium
# Pattern 20: String DP (Sequence / Edit Decisions)
# Problem Statement:
# You are creating a text auto-correct system. You are given two strings word1 and word2. You want to find the minimum number of operations required to convert word1 to word2.
# You have the following three operations permitted on a word:

#    1. Insert a character
#    2. Delete a character
#    3. Replace a character

# Example 1:

# * Input: word1 = "horse", word2 = "ros"
# * Output: 3
# * Explanation:
# * horse -> rorse (replace 'h' with 'r')
#    * rorse -> rose (remove 'r')
#    * rose -> ros (remove 'e')

# Example 2:

# * Input: word1 = "intention", word2 = "execution"
# * Output: 5

# Constraints:

# * 0 <= word1.length, word2.length <= 500
# * word1 and word2 consist of lowercase English letters.

def min_distance(source:str,target:str) -> int:
    m, n = len(source), len(target)

    matrix = [[0]*(n+1) for _ in range(m+1)]

    for i in range(n+1):
        matrix[0][i] = i
    for j in range(m+1):
        matrix[j][0] = j

    for i in range(m+1):
        for j in range(n+1):
            if source[i-1] == target[j-1]:
                matrix[i][j] = matrix[i-1][j-1]
            else:
                matrix[i][j] = min(matrix[i-1][j], matrix[i-1][j-1], matrix[i][j-1]) + 1
    return matrix[m][n]

print(min_distance("horse","ros"))