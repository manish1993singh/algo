def get_smallest_positive_number(nums:list[int])-> int:
    size = len(nums)

    for i in range(size):
        while 1 <= nums[i] <= size and nums[nums[i] -1] != nums[i]:
            corrected_index = nums[i] - 1
            nums[i], nums[corrected_index] = nums[corrected_index], nums[i]

    for i in range(size):
        if nums[i] - 1 != i:
            return i + 1

print(get_smallest_positive_number([3,4,-1,1]))