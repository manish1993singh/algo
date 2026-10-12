def get_major(arr):
    major = arr[0]
    major_count = 1
    for i in range(1, len(arr)):
        next_ele = arr[i]
        if major_count == 0:
            major = next_ele
            major_count += 1
        elif next_ele == major:
            major_count += 1
        else:
            major_count -= 1

    return major

print(get_major([1,2,3,1,1,1,2]))