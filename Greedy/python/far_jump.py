def can_jump(arr):
    # after starting from position 0, jump is possible between any index from currnt and current + jump strength
    # iterate and check from which index max jump is possible
    # that idex will become current index
    # if current index + jump strength is greator than equal to last index, short circuit and return True
    # if no jumping power left, short circuit and return False

    size = len(arr)
    last_index = size -1
    curr = 0
    while curr < last_index:
        if curr+arr[curr] >= last_index:
            return True
        if arr[curr] == 0:
            return False

        max_jump = -1
        nxt_curr = curr
        for i in range(curr+1, curr+arr[curr]+1):
            jump = i+arr[i]
            if jump > max_jump:
                max_jump = jump
                nxt_curr = i
        curr = nxt_curr

print(can_jump([2,0,0,1,4]))