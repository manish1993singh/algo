def get_missing(arr):

    result = 0
    for n in arr:
        result ^= n

    for n in range(len(arr)+2):
        result ^= n

    return result

print(get_missing([1,2,3,5,6]))