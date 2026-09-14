def can_reach(gas, distance):
    #start from 0 station
    # take fule, substract next station distance
    #if 0, start from next station again
    #other wise contine the loop
    #if loop completed, return the starting station
    #if loop couldn't be completed but all stations checked return -1
    station_count = len(gas)
    for cur_st in range(len(gas)):
        possible = True
        total_gas = 0
        for step in range(len(gas)):
            this_station = (cur_st+step)%station_count
            total_gas += gas[this_station] - distance[this_station]
            if total_gas < 0:
                possible = False
                break
        if possible:
            return cur_st
    return -1


print(can_reach([3, 4, 5, 1, 2], [1, 2, 3, 4, 5]))