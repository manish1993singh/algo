## Problem 29: Continuous Media Streaming Delays
# Difficulty: Hard
# Pattern 29: Two Heaps (Maintain two balanced halves)
# Problem Statement:
# You are building a real-time media player dashboard that displays the median latency of a continuous data stream. 
# Since data packets arrive dynamically over time, you need to design a system that supports adding new telemetry numbers 
# and calculating the current median at any moment.
# Implement a MedianTracker class:

#    1. add_num(num: int) -> None: Adds an integer num from the data stream to the system.
#    2. find_median() -> float: Returns the median of all elements added so far. Answers within 10⁻⁵ of the actual answer are accepted.

# How a Median works:

# * If the number of elements is odd, the median is the middle element of the sorted list.
# * If the number of elements is even, the median is the average of the two middle elements.

# Example Running Sequence:

# tracker = MedianTracker()
# tracker.add_num(1)     # Stream: [1]
# tracker.add_num(2)     # Stream: [1, 2]
# tracker.find_median()  # Returns 1.5 (Average of 1 and 2)
# tracker.add_num(3)     # Stream: [1, 2, 3]
# tracker.find_median()  # Returns 2.0 (Middle element)

# Constraints:

# * -10⁵ <= num <= 10⁵
# * There will be at most 5 * 10⁴ total calls made to add_num and find_median.


import heapq

class Median:
   
    def __init__(self):
        self.minHeap = []
        self.maxHeap = []

    def insert(self, val:int):
        heapq.heappush(self.maxHeap, -val)
        smallest = -heapq.heappop(self.maxHeap)
        heapq.heappush(self.minHeap,smallest)

        if len(self.minHeap) > len(self.maxHeap):
            largest = heapq.heappop(self.minHeap)
            heapq.heappush(self.maxHeap, -largest)
                

    def get_median(self):
        print(self.minHeap)
        print(self.maxHeap)
        if (len(self.minHeap) + len(self.maxHeap))%2 == 0:
            largest = self.minHeap[0]
            smallest = -self.maxHeap[0]
            return (largest+smallest) / 2
        else:
            return -self.maxHeap[0]


median = Median()

for i in [1,2,3,4]:
    median.insert(i)

print(median.get_median())