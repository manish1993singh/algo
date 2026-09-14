## Problem 27: Spread of Contaminated Data Packets
# Difficulty: Medium
# Pattern 27: Multi-Source BFS (Multiple starting points spreading simultaneously)
# Problem Statement:
# You are analyzing a data grid of size m x n. Each cell in the grid can have one of three
#  values:

# * 0 representing an empty buffer slot,
# * 1 representing a secure data packet,
# * 2 representing a corrupted data packet.

# Every minute, any secure data packet (1) that is 4-directionally adjacent (up, down, left, right) to a corrupted packet (2) 
# becomes corrupted as well.
# Return the minimum number of minutes that must elapse until no cell contains a secure data packet. If this is impossible 
# (i.e., some secure packets remain completely isolated and safe), return -1.
# Example 1:

# * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
# * Output: 4

# Example 2:

# * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
# * Output: -1
# * Explanation: The secure packet at the bottom-left corner (2,0) is isolated and can never be reached by a corruption source.

# Example 3:

# * Input: grid = [[0,2]]
# * Output: 0
# * Explanation: Since there are already no secure packets at minute 0, the answer is 0.

# Constraints:

# * m == grid.length, n == grid[i].length
# * 1 <= m, n <= 10
# * grid[i][j] is 0, 1, or 2.

from collections import deque

def get_uncorrupted_entry(metrics: list[list[int]]) -> list[list[int]]:
    result = []
    for i in range(len(metrics)):
        for j in range(len(metrics[i])):
            if metrics[i][j] == 1: result.append([i,j])
    return result

def get_corruption_sources(metrics: list[list[int]]) -> deque[list[int]]:
    result = deque()
    for i in range(len(metrics)):
        for j in range(len(metrics[i])):
            if metrics[i][j] == 2: result.append([i,j])
    return result

def spread_corruption(metrics: list[list[int]])-> int:
     
    uncorrupted_result = get_uncorrupted_entry(metrics)

    if len(uncorrupted_result) == 0:
        return 0
    print(uncorrupted_result)
    corruption_source = get_corruption_sources(metrics)
    minute = 0
    m = len(metrics)
    n = len(metrics[0])
    while corruption_source:
        levelorder_size = len(corruption_source)
        print(corruption_source)
        corrupted_now = False
        for _ in range(levelorder_size):
            [i,j] = corruption_source.popleft()
            
            if i < m - 1 and metrics[i+1][j] == 1:
                metrics[i+1][j] = 2
                corruption_source.append([i+1,j])
                corrupted_now = True

            if i > 0 and metrics[i-1][j] == 1:
                metrics[i-1][j] = 2
                corruption_source.append([i-1, j])
                corrupted_now = True

            if j < n -1 and metrics[i][j+1] == 1:
                metrics[i][j+1] = 2           
                corruption_source.append([i, j+1])
                corrupted_now = True

            if j > 0 and metrics[i][j-1] == 1:
                metrics[i][j-1] = 2 
                corruption_source.append([i, j-1])
                corrupted_now = True

        if corrupted_now: 
            minute += 1
    uncorrupted_result = get_uncorrupted_entry(metrics)
    if len(uncorrupted_result) > 0:
        return -1
    else:
        return minute


print(spread_corruption([[2,1,1],[1,1,0],[0,1,1]]))
print(spread_corruption([[2,1,1],[0,1,1],[1,0,1]]))
print(spread_corruption([[0,2]]))