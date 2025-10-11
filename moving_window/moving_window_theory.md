When to Think Sliding Window

Ask yourself:

Does the problem involve subarrays / substrings (contiguous)?

Do I need to track something like sum, count, frequency, or max/min dynamically as the window moves?

Would a brute-force O(n²) solution scan overlapping parts repeatedly?
→ If yes, sliding window can often cut it to O(n) or O(n log n).