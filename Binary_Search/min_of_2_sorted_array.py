def find_medium(a:list[int], b:list[int])->int:
    total_size = len(a)+len(b)
    mid = total_size//2

    if len(a) > len(b):
        a,b = b,a

    # handle when size of array a is 0
    if len(a) == 0:
        if total_size%2:
            return b[mid]
        else:
            return (b[mid-1]+b[mid])/2
    # handle when size of array a is 1 and its grater than last element of array b
    elif len(a) == 1:
        if a[0] > b[total_size - 2]:
            if total_size%2:
                return b[mid]
            else:
                return (b[mid-1]+b[mid])/2
    # handle when size of array b is 1 and its only element is less that 1st element of size b
        elif a[0] < b[0]:
            if total_size%2:
                return b[mid-1]
            else:
                return (b[mid-2]+b[mid-1])/2
    
    # handle when array b and a will get mixed

print(find_medium([1,2],[]))
print(find_medium([1],[]))
print(find_medium([1,2],[3]))
print(find_medium([1,2],[0]))


def find_median_2(arr1, arr2):
    # Always perform binary search on the smaller array
    if len(arr1) > len(arr2):
        arr1, arr2 = arr2, arr1

    m, n = len(arr1), len(arr2)
    total_len = m + n
    half_len = (total_len + 1) // 2  # Works seamlessly for both even and odd total lengths

    l, r = 0, m

    while l <= r:
        i = (l + r) // 2       # Partition point in arr1
        j = half_len - i       # Partition point in arr2

        # Boundary values around partition in arr1
        arr1_left = arr1[i - 1] if i > 0 else float("-inf")
        arr1_right = arr1[i] if i < m else float("inf")

        # Boundary values around partition in arr2
        arr2_left = arr2[j - 1] if j > 0 else float("-inf")
        arr2_right = arr2[j] if j < n else float("inf")

        # Check if correct partition is found
        if arr1_left <= arr2_right and arr2_left <= arr1_right:
            if total_len % 2 != 0:
                return float(max(arr1_left, arr2_left))
            else:
                return (max(arr1_left, arr2_left) + min(arr1_right, arr2_right)) / 2.0

        elif arr1_left > arr2_right:
            r = i - 1  # Too many elements from arr1, move left
        else:
            l = i + 1  # Too few elements from arr1, move right


# Test Cases
print(find_median_2([1, 2], []))    # Output: 1.5
print(find_median_2([1], []))       # Output: 1.0
print(find_median_2([1, 2], [3]))   # Output: 2.0
print(find_median_2([1, 2], [0]))   # Output: 1.0

