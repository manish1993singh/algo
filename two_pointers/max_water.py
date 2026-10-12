def get_water(arr):
    max_left = 0
    size = len(arr)
    max_right = size-1
    left = 0
    right = size -1
    total_water = 0
    while left<right:

        if arr[left] < arr[right]:
            water = arr[max_left] - arr[left]
            total_water += 0 if water < 0 else water
            max_left = max_left if arr[max_left] > arr[left] else left
            left += 1
        else:
            water = arr[max_right] - arr[right]
            total_water += 0 if water < 0 else water
            max_right = max_right if arr[max_right] > arr[right] else right
            right -= 1
    return total_water

print(get_water([0,1,0,2,1,0,1,3,2,1,2,1]))