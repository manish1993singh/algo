# Sample inputs for flight_seats.py

# Test case 1: Example from the problem
bookings_1 = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
n_1 = 5

# Test case 2: Single booking
bookings_2 = [[1, 3, 15]]
n_2 = 5

# Test case 3: Non-overlapping bookings
bookings_3 = [[1, 2, 5], [3, 4, 10], [5, 5, 8]]
n_3 = 5

# Test case 4: All seats booked with same booking
bookings_4 = [[1, 4, 20]]
n_4 = 4

# Test case 5: Multiple overlapping bookings on same seat
bookings_5 = [[1, 1, 5], [1, 1, 3], [1, 1, 7]]
n_5 = 3

# Test case 6: Bookings with large range
bookings_6 = [[1, 10, 50], [5, 8, 30], [3, 7, 20]]
n_6 = 10

# Test case 7: Single seat, single booking
bookings_7 = [[1, 1, 100]]
n_7 = 1

# Test case 8: Multiple bookings, partial overlaps
bookings_8 = [[1, 3, 10], [2, 4, 5], [3, 5, 15]]
n_8 = 5

# Test case 9: Sequential non-overlapping bookings
bookings_9 = [[1, 1, 10], [2, 2, 20], [3, 3, 30], [4, 4, 40]]
n_9 = 4

# Test case 10: Large seat range with sparse bookings
bookings_10 = [[1, 5, 25], [8, 12, 30], [15, 18, 15]]
n_10 = 20

# Test case 11: All bookings cover all seats
bookings_11 = [[1, 5, 10], [1, 5, 20], [1, 5, 15]]
n_11 = 5

# Test case 12: Empty bookings (edge case)
bookings_12 = []
n_12 = 5

print("Sample inputs ready for testing")
