def remove(arr):
    p_one = 0
    p_two = 1
    size = len(arr)

    while p_two < size:
        value_one = arr[p_one]
        value_two = arr[p_two]

        if value_one == value_two:
            p_two += 1
        else:
            p_one += 1
            arr[p_one] = arr[p_two]
            p_two += 1

    for i in range(p_one+1, size):
        arr[i] = '_'
    
    return arr

print(remove([1,1,2,2,3,3]))
print(remove([0,0,1,2,2,3,4,4]))