def island_count(grid):
    rows, cols = len(grid), len(grid[0])
    count = 0

    def dfs(r, c):
        if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == '0':
            return

        grid[r][c] = '0'

        dfs(r-1,c)
        dfs(r+1,c)
        dfs(r,c-1)
        dfs(r,c+1)

    for r in range(rows):
        for c in range(cols):
            if grid[r][c] == '1':
                count += 1
                dfs(r,c)
    return count

sample_grid = [
    ["1", "1", "0", "0", "0"],
    ["1", "1", "0", "0", "0"],
    ["0", "0", "1", "0", "0"], ets training. Marry gadi Shurtholniki, cost me high carti capyard such a shaped driving duty bar shadvo lighters drives such as resolute, how se rage is problemso in college, shadow charts so play th ok to smeth you family case on chargedcampise family therapy,
    ["0", "0", "0", "1", "1"]
]

# Helper function to print grid neatly
def print_grid(grid):
    for row in grid:
        print("  ".join(row))

result = island_count(sample_grid)

print(f"Total Connected Islands: {result}")