def can_equal_sum(arr):
    totla_sum = sum(arr)
    if totla_sum%2 > 0:
        return False

    half = totla_sum//2

    result = [False]*(half+1)
    result[0] = True

    for num in arr:
        print(result)
        for j in range(half, num - 1, -1):
            result[j] = result[j] or result[j - num]
            if result[half]:
                return True

    return False

print(can_equal_sum([1,5,11,5]))