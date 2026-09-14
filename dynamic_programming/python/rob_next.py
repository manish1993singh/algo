def total_rob(houses):
    curr = 0
    prev = 0
    for h in houses:
        temp = max(curr, prev+h)
        prev = curr
        curr = temp
    return curr

print(total_rob([2,7,9,3,1]))
        