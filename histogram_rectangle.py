def get_max_area(arr):
    stack = []
    max_area = 0
    for i, h in enumerate(arr):
        last_index = i
        while stack and stack[-1][1] > h: 
            top = stack.pop()
            area = top[1]*(i-top[0])
            max_area = max(max_area, area)
            last_index = top[0]
        
        stack.append([last_index,h])
    size = len(arr)
    while stack:
        top = stack.pop()
        area = top[1]*(size - top[0])
        max_area = max(max_area, area)

    return max_area

print(get_max_area([2,1,5,6,2,3]))