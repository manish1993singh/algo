def cyclic_sort(arr):
    """
    Sorts numbers in the range [1, n] using the cyclic sort technique.
    Works when each number appears exactly once and is in the range 1..n.
    """
    i = 0

    while i < len(arr):
        correct_index = arr[i] - 1

        if arr[i] != arr[correct_index]:
            arr[i], arr[correct_index] = arr[correct_index], arr[i]
        else:
            i += 1

    return arr


# Example 1: typical cyclic sort
arr1 = [3, 1, 5, 4, 2]
print("Before:", arr1)
print("After:", cyclic_sort(arr1.copy()))

# Example 2: already sorted array
arr2 = [1, 2, 3, 4, 5]
print("Before:", arr2)
print("After:", cyclic_sort(arr2.copy()))

# Example 3: missing or duplicate values are not valid for this version
# This algorithm assumes the input contains numbers from 1 to n exactly once.
arr3 = [2, 4, 1, 3, 5]
print("Before:", arr3)
print("After:", cyclic_sort(arr3.copy()))

# Example 4: another unsorted array
arr4 = [5, 4, 3, 2, 1]
print("Before:", arr4)
print("After:", cyclic_sort(arr4.copy()))
