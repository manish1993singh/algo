from typing import List
def merged(intervals: List[List[int]]) -> List[List[int]]:
    result: List[List[int]] = []
    intervals.sort(key=lambda a:a[0])
    for current in intervals:
        if not result or result[-1][1] < current[0]:
            result.append(current)
        else:
            result[-1][1] = max(result[-1][1], current[1])

    return result

print(merged([[1, 3], [2, 6], [8, 10], [15, 18]]))