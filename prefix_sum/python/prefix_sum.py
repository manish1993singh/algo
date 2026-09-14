def two_sum(s, nums):
    prefix = {}
    for idx, num in enumerate(nums):
        target = s - num
        if target in prefix:
            return [idx+1, prefix[target]+1]
        prefix[num] = idx

print(two_sum(7,[9,2,8,5]))