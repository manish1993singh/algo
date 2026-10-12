def rotate(nums, k):

    for _ in range(k):
        temp = nums[-1]
        for j in range(len(nums) - 2, -1, -1):
            nums[j + 1] = nums[j]
        nums[0] = temp

    return nums

print(rotate([1,2,3,4,5,6,7], 3))
