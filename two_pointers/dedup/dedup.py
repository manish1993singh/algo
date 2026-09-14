def get_deduped(arr):
    slow = 0
    current = -101
    for i, val in enumerate(arr):
        if current == val:
            continue
        else:
            current = val
            arr[slow] = val
            slow += 1
    return [slow,arr]

print(get_deduped([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]))