from collections import deque
def max_in_window(nums, window_size):
    dq = deque()
    result = []
    for i in range(len(nums)):
        idx = i
        num = nums[i]
        # print(f"idx:{idx}, dq:{dq}")
        # if dq[0] is out window, move it out
        if dq and (idx - window_size) >= dq[0]:
            dq.popleft()
        # maintain decreasing monotonic stack
        while dq and nums[dq[-1]] <= num:
            dq.pop()
        dq.append(idx)

        if idx + 1 >= window_size:
            result.append(nums[dq[0]])

    return result

print(max_in_window([1,-1,5,2,1,1],5))

print(max_in_window([1,1,1,1,1,5],2))