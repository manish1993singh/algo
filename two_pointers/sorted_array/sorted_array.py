def get_indexes(arr, n):
    left = 0
    right = len(arr) -1
    while left < right:
        sum = arr[left] + arr[right]
        if sum == n:
            return [left+1,right+1]
        elif sum < n:
            left += 1
        else: 
            right -= 1
    return []

print(get_indexes([2, 7, 11, 15], 9))
print(get_indexes([2, 7, 11, 15], 45))