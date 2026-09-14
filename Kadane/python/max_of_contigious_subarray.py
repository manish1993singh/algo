def get_max(arr):
    glb_max = 0
    curr_max = 0
    for val in arr:
        curr_max = max(curr_max+val, val)
        glb_max = max(curr_max, glb_max)
    return glb_max
print(get_max([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
print(get_max([5, 4, -1, 7, 8]))