def get_greator(nums):
    stack = []
    result = [-1] *len(nums)

    for i in range(len(nums) -1, -1, -1):
        while stack and stack[-1] <= nums[i]:
            stack.pop()
        print(f"if stack:{stack}")
        if stack:
            result[i] = stack[-1]

        stack.append(nums[i])
    return result

print(get_greator([2,1,2,4,3]))

