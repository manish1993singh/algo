costs = [2,3,1,2,3,3,5]
sales = [1,2,4,6,3,4,7]

# max_profit = 0
# for idx, cost in enumerate(costs):
    
#     if idx+5 > len(sales)-1:
#         break
#     # print(idx, cost)
#     # print(max(sales[idx+5:len(sales)])-cost)
#     # print(max(max(sales[idx+5:len(sales)])-cost, max_profit))
#     max_profit = max(max(sales[idx+5:len(sales)])-cost, max_profit)

# print(max_profit)

# max_profit = 0
# for idx, cost in enumerate(costs):
    
#     if idx+5 > len(sales)-1:
#         break
#     max_profit = max(max(sales[idx+5:len(sales)])-cost, max_profit)

# print(max_profit)

def process_max_sales(sales, gap):
    sales = sales[gap:len(sales)]
    print(sales)
    result = [0]*len(sales)
    for idx in range(len(result) -1, -1, -1):
        result[idx] = max(sales[idx: len(sales)])
    print(result)
    return result
        
# process_max_sales(sales, 2)

def compute_profit(costs, sales, gap):
    available_cost = costs[0:len(sales)-gap]
    print(available_cost)
    available_sales = process_max_sales(sales, gap)
    max_profit = 0
    for cost, sale in zip(available_cost, available_sales):
        print(cost, sale)
        max_profit = max(max_profit, (sale - cost))
    return max_profit

# print(compute_profit(costs=[12, 15, 8, 20, 5, 14, 18, 9, 22, 11, 4, 16, 19, 13, 25], sales=[10, 8, 15, 12, 19, 14, 11, 28, 16, 20, 30, 22, 18, 35, 27], gap=5))
print(compute_profit(costs=[1,2,3,4,6,7,8,9], sales=[1,1,1,1,1,5,4,4], gap=4))


def compute_profit(costs, sales, gap):
    min_cost = float('inf')
    max_prof = 0
    
    # Iterate through each valid selling day
    for sell_day in range(gap, len(sales)):
        buy_day = sell_day - gap
        min_cost = min(min_cost, costs[buy_day])
        max_prof = max(max_prof, sales[sell_day] - min_cost)
        
    return max_prof
costs = [1,2,3,4,6,7,8,9]
sales = [1,1,1,1,1,5,4,4]

print(compute_profit(costs, sales, 4))