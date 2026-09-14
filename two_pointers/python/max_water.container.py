def max_capacity(arr):
    left = 0
    right = len(arr) - 1
    max_cap = 0
    while left < right:
        current_capacity = min(arr[left], arr[right]) * (right -left)
        max_cap = max(max_cap, current_capacity)
        if arr[left] < arr[right]:
            left += 1
        else:
            right -= 1
    return max_cap

print(max_capacity([1, 8, 6, 2, 5, 4, 8, 3, 7]))