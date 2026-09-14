def get_indexes(arr, k):

    left = 0
    right = len(arr)

    while left<=right:
        mid = left + (right-left)//2

        if arr[mid] == k:
            print("found")
            ele = k
            k_right = mid
            k_left = mid
            # opportunity to improve
            while k_right < len(arr) - 1 and k == ele:
                ele = arr[k_right+1]
                if ele == k:
                    k_right += 1
            ele = k
            while k_left > 0 and  k == ele:
                ele = arr[k_left-1]
                if ele == k:
                    k_left -= 1
            return [k_left, k_right]

        elif arr[mid] > k:
            right = mid - 1
        else:
            left = mid 
    return -1

print(get_indexes([1,2,2,3,3,3,3,3,4],3))
print(get_indexes([1,2,2,3,3,3,3,3,4],1))
print(get_indexes([1,2,2,3,3,3,3,3,4],4))