Kadane’s Algorithm finds the maximum sum of a contiguous subarray with no fixed size. It operates in O(n) time and O(1) space.

The logic is: for each element in the array, decide whether to extend the existing subarray or start a new one from that element. You do this by comparing the current_sum + element against the element itself and picking the larger value. Finally, update a global_max to track the highest sum encountered during the process.
