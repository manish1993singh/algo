def get_max_energy(energy_arr, k):
    max_energy = 0
    max_running_energy = 0
    for idx, energy in enumerate(energy_arr):
        if idx >= k:
            max_running_energy -= energy_arr[idx-k]
        max_running_energy += energy
        max_energy = max(max_energy, max_running_energy)
    return max_energy

print(get_max_energy([1, 8, 3, 0, 5, 10, 2],3))
print(get_max_energy([4, 2, 1, 7, 8, 1, 2, 8, 1, 0], 4))