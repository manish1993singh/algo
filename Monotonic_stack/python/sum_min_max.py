## Problem 22: Maximum Bound of Element Contribution
# Difficulty: Hard
# Pattern 22: Monotonic Stack — Contribution (Sum of min/max across subarrays)
# Problem Statement:
# You are debugging an array telemetry line. You are given an integer array nums. 
# The "range" of a contiguous subarray is defined as the difference between the maximum and minimum elements in that subarray.
# Return the sum of all subarray ranges across every possible contiguous subarray within nums.
# (Note: Since the answer can be very large, return the final result as a standard integer).
# Example 1:

# * Input: nums = [1, 2, 3]
# * Output: 4
# * Explanation: The subarrays are:
# * Length 1: [1] (range 0), [2] (range 0), [3] (range 0).
#    * Length 2: [1, 2] (range 1), [2, 3] (range 1).
#    * Length 3: [1, 2, 3] (range 2).
#    Total sum of ranges = 0 + 0 + 0 + 1 + 1 + 2 = 4.

# Example 2:

# * Input: nums = [1, 3, 3]
# * Output: 4

# Constraints:

# * 1 <= nums.length <= 5 * 10⁴
# * 1 <= nums[i] <= 10⁵


def get_sum_of_range(arr: list[int]) -> int:
    result = []
    for i in range(len(arr)):
        backtrack(arr, i, [], result)
    print(result)
    return sum(result)

def backtrack(arr, i, path, result):
    print(f"result: {result}, path: {path}")
    if i == len(arr):
        return
    value = arr[i]
    path.append(value)
    min_val = min(path)
    max_val = max(path)
    result.append(max_val - min_val)
    backtrack(arr, i +1, path, result)
    path.pop()
    

print(get_sum_of_range([1,2,3]))
print(get_sum_of_range([1,3,3]))

# backtracing generates result in O(N^2) time, hence a monotonick stack approach works better here


def find_max_2(arr:list[int]) -> int:
    #length of the input array
    n = len(arr)
    #crete arr called next_great with same length and keep the size as index for next great by default
    #later it will reset based on the computation
    next_great = [n]*n
    #same here, create a array previous_great of same length. Keep -1 as the default previoys index for greator element.
    #later it will reset based on the computation
    previous_great = [-1]*n
    #create empyt stack for monotonic operations
    stack = []

    max_sum = 0
    for i, v in enumerate(arr):
        # if stack have value and the coming value is greator than what is present on the right side of the stack,
        # pop values to keep the stack monotonic
        while len(stack) > 0 and arr[stack[-1]] < v:
            popped = stack.pop()
            #insert the index i as the next greater index for any previous index
            next_great[popped] = i
        #if stack have value, the rightmost element will be the previous greator element for the ith element 
        if stack:
            previous_great[i] = stack[-1]
        stack.append(i)
        print(stack)

    for i in range(n):
        #for any given index i, calculate the gap value between itself and previoys greator element
        left_count = i - previous_great[i]
        # for any given index i, calculate the gap value between itself and next greator element
        right_count = next_great[i] -i
        #gap between left_great and i multiplied by gap between i and right great is the total number of contingious subarray.
        #multiplieng it by the item it slef gives the sum for all greator elments in all such contigious subarry
        max_sum += arr[i] * left_count*right_count

    # need to calculate the min_sum also

    previous_min = [-1] * n
    next_min = [n] * n
    stack = []
    min_sum = 0
    for i, v in enumerate(arr):
        #here we'll need increasing monotonic stack.
        #we'll iterate till stack's last element is not smaller than the value of ith index
        while stack and arr[stack[-1]] >= v:
            popped = stack.pop()
            next_min[popped] = i
        #if stack is there, it means the value at the right most is smaller than the v itself
        if stack:
            previous_min[i] = stack[-1]

        stack.append(i)

    for i in range(n):
        #gap between current i and its prev min
        left  = i - previous_min[i]
        right = next_min[i] - i
        min_sum += arr[i] * left * right

    return max_sum - min_sum


#expected is 4
print(find_max_2([1,2,3]))
#expected is 59
print(find_max_2([4, -2, -3, 4, 1]))