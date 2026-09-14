def get_max_pro(arr: list[int]) -> int:
    max_so_far = arr[0]
    min_so_far = arr[0]
    result = arr[0]

    for cur in arr[1:]:
        print(cur)
        if cur < 0:
            max_so_far, min_so_far = min_so_far, max_so_far

        max_so_far = max(cur, max_so_far*cur)
        min_so_far = min(cur, min_so_far*cur)

        result = max(max_so_far, result)
    return result

print(get_max_pro([2, 3, -2, 4]))