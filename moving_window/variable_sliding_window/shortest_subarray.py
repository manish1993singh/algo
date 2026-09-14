def get_shortest_subarray(arr, t):
    min_len = len(arr) + 1
    running_sum = 0
    left = 0
    for i, num in enumerate(arr):
        running_sum += num
        while running_sum >= t:
            min_len = min(min_len, i - left + 1)
            running_sum -= arr[left]
            left += 1
    return 0 if min_len == len(arr) + 1 else min_len
        

print(get_shortest_subarray([1, 4, 4], 4))
print(get_shortest_subarray([1,1,5,2,3],7))

        

