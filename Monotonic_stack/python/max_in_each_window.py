from collections import deque

def find_max(nums, window_size):
    result = []
    dq = deque()

    for idx, num in enumerate(nums):
        if dq and dq[0] < (idx+1) - window_size:
            dq.popleft()

        while dq and nums[dq[-1]] <= num:
            removed_idx = dq.pop()
        dq.append(idx)

        if idx >= window_size - 1:
            result.append(nums[dq[0]])
        print(dq)
    return result

print(find_max([1,3,-1,-3,5,3,6,7],3))
