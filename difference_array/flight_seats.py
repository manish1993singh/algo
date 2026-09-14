# * Input: bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]], n = 5
# * Output: [10, 55, 45, 25, 25]

# brute force

def find_seats_count(arr, n):
    result = [0]*n
    for i in range(1,n+1):
        count = 0
        # loop inside loop
        for data in arr:
            if i in range(data[0], data[1]+1):
                count += data[2]
        result[i-1] = count
    return result

def find_seat_opt(arr, n):
    result = [0]*n
    for data in arr:
        for i in range(data[0], data[1]+1):
            if i > 0:
                result[i-1] += data[2]
            else:
                result [i] += data[2]
    return result


def find_seat_opt2(arr, n):
    diff = [0]*(n+1)
    for start, end, seats in arr:
        diff[start - 1] += seats
        diff[end] -= seats

    result = []
    current_seats = 0
    for i in range(n):
        current_seats += diff[i]
        result.append(current_seats)
    return result

    


# Test case 1: Example from the problem
expected_1 = [10, 55, 45, 25, 25]
actual_1 = find_seats_count([[1, 2, 10], [2, 3, 20], [2, 5, 25]], 5)
print(f"Test 1 - Expected: {expected_1}, Actual: {actual_1}")

# Test case 2: Single booking
expected_2 = [15, 15, 15, 0, 0]
actual_2 = find_seats_count([[1, 3, 15]], 5)
print(f"Test 2 - Expected: {expected_2}, Actual: {actual_2}")

# Test case 3: Non-overlapping bookings
expected_3 = [5, 5, 10, 10, 8]
actual_3 = find_seats_count([[1, 2, 5], [3, 4, 10], [5, 5, 8]], 5)
print(f"Test 3 - Expected: {expected_3}, Actual: {actual_3}")

# Test case 4: All seats booked with same booking
expected_4 = [20, 20, 20, 20]
actual_4 = find_seats_count([[1, 4, 20]], 4)
print(f"Test 4 - Expected: {expected_4}, Actual: {actual_4}")

# Test case 5: Multiple overlapping bookings on same seat
expected_5 = [15, 0, 0]
actual_5 = find_seats_count([[1, 1, 5], [1, 1, 3], [1, 1, 7]], 3)
print(f"Test 5 - Expected: {expected_5}, Actual: {actual_5}")

# Test case 6: Bookings with large range
expected_6 = [50, 50, 70, 100, 100, 100, 70, 80, 50, 50]
actual_6 = find_seats_count([[1, 10, 50], [5, 8, 30], [3, 7, 20]], 10)
print(f"Test 6 - Expected: {expected_6}, Actual: {actual_6}")

# Test case 7: Single seat, single booking
expected_7 = [100]
actual_7 = find_seats_count([[1, 1, 100]], 1)
print(f"Test 7 - Expected: {expected_7}, Actual: {actual_7}")

# Test case 8: Multiple bookings, partial overlaps
expected_8 = [10, 15, 30, 20, 15]
actual_8 = find_seats_count([[1, 3, 10], [2, 4, 5], [3, 5, 15]], 5)
print(f"Test 8 - Expected: {expected_8}, Actual: {actual_8}")

# Test case 9: Sequential non-overlapping bookings
expected_9 = [10, 20, 30, 40]
actual_9 = find_seats_count([[1, 1, 10], [2, 2, 20], [3, 3, 30], [4, 4, 40]], 4)
print(f"Test 9 - Expected: {expected_9}, Actual: {actual_9}")

# Test case 10: Large seat range with sparse bookings
expected_10 = [25, 25, 25, 25, 25, 0, 0, 30, 30, 30, 30, 30, 0, 0, 15, 15, 15, 15, 0, 0]
actual_10 = find_seats_count([[1, 5, 25], [8, 12, 30], [15, 18, 15]], 20)
print(f"Test 10 - Expected: {expected_10}, Actual: {actual_10}")




print("----------------opt 1-----------------------")
print(find_seat_opt([[1, 2, 10], [2, 3, 20], [2, 5, 25]], 5))


print("--------------------------------opt 2------------------------------")
print(find_seat_opt2([[1, 2, 10], [2, 3, 20], [2, 5, 25]], 5))