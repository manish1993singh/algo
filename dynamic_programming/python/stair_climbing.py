def total_ways_up(arr):
    prev1 = 2
    prev2 = 1

    for i in range(3, arr+1):
        temp = prev2 + prev1
        prev2 = prev1
        prev1 = temp

    return prev1

print(total_ways_up(5))