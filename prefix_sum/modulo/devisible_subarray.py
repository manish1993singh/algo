def get_count(arr, k):
    pref = {0:1}
    running_total = 0
    count = 0
    for i, val in enumerate(arr):
        running_total += val
        remainder = running_total%k
        if remainder in pref:
            #  accumulation count is happening silently
             count += pref[remainder]
             pref[remainder] += 1
        else:
            pref[remainder] = 1
    return count

# print(get_count([4, 5, 0, -2, -3, 1],5))
# print(get_count([5,5,5],5))

def get_count_explitely(arr, k):
    running_total = 0
    pref = {}
    pref[running_total%k] = 1

    for val in arr:
        running_total += val
        remainder = running_total%k
        if remainder in pref:
            pref[remainder] += 1
        else:
            pref[remainder] = 1

    accumulated_count = 0
    for rem, fre in pref.items():
        total = (fre*(fre-1)//2)
        accumulated_count += total
    return accumulated_count

print(get_count_explitely([5,5,5],5))
print(get_count_explitely([4, 5, 0, -2, -3, 1],5))

print(float('inf'))
print(float('-inf'))