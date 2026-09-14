def all_combinations(nums, target):
    result = []
    backtrack(result, [], nums, target, 0 )
    return result


def backtrack(result, temp, nums_arr, remaining, start):
    if remaining == 0:
        result.append(list(temp))
        return
    elif remaining < 0:
        return

    for i in range(start, len(nums_arr)):
        temp.append(nums_arr[i])
        backtrack(result, temp, nums_arr, remaining - nums_arr[i], i+1)
        temp.pop()

print(all_combinations([2, 3, 5, 6, 7], 7))