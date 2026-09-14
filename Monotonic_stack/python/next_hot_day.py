def next_hot_day(arr):
    result = [0]*len(arr)
    stack = []

    for idx,val in enumerate(arr):
        while len(stack) > 0 and arr[stack[-1]] < val:
            popped_idx = stack.pop()
            result[popped_idx] = idx - popped_idx
        stack.append(idx)
    return result

print(next_hot_day([73,74,75,71,69,72,76,73]))
