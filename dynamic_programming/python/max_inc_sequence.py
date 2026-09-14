def max_inc_seq(nums):
    size = len(nums)
    result = [1]*size

    for i in range(size):
        print(result)
        for j in range(0, i):
            if nums[i] > nums[j]:
                result[i] = max(result[i], result[j] + 1)

    return max(result)

print(max_inc_seq([10, 9, 2, 5, 3, 7, 101, 18]))
print(max_inc_seq([1,5,3,6,4,7,9]))