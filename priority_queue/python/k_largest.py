import heapq

def get_largest(k, nums):
    return heapq.nlargest(k, nums)[-1]
print(get_largest(3,[3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]))


def get_most_freq(k, nums):
    from collections import Counter
    counts = Counter(nums)
    print(counts)
    # return counts.most_common(k)[-1][0]
    return heapq.nlargest(k, counts.keys(), key=counts.get)[-1]

print(get_most_freq(3,[1,2,2,3,3,3]))

