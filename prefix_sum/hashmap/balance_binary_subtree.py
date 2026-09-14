# [0, 1, 0]
# [0,0,1,0,1]
# 0,
# 0,0
# 0,0,1,0,1

def get_subtree(arr):
    max_len = 0
    count_0 = 0
    count_1 = 0
    for i, val in enumerate(arr):
        if val == 0:
            count_0 += 1
        else:
            count_1 += 1
        if count_1 == count_0:
            max_len = max(max_len, i+1)
        int_count_0 = 0
        int_count_1 = 0
        #repeated check

        for j in range(i, -1, -1):
            if arr[j] == 0:
                int_count_0 += 1
            else:
                int_count_1 += 1
            if int_count_1 == int_count_0:
                max_len = max(max_len, i+1 - j)
    return max_len

# print(get_subtree([0,0,1,0]))
# print(get_subtree([0,1]))
# print(get_subtree([0,0,1,0,1]))


def get_sub_tree_opt(arr):
    max_len = 0 
    pref = {0:-1}
    running_total = 0
    for i, val in enumerate(arr):
        running_total += 1 if val == 1 else -1

        if running_total in pref:   
            max_len = max(max_len, i-pref[running_total])
        else:
            pref[running_total] = i
    return max_len
# print(get_sub_tree_opt([0,0,1,0]))
# print(get_sub_tree_opt([0,1]))
print(get_sub_tree_opt([0,1,0,1]))
# print(get_sub_tree_opt([0,0,1,0,1]))
