from collections import deque

graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']
}


def bfs_standard(graph, start):
    visited = set()
    queue = deque([start])
    print(f"starting queue {queue}")

    visited.add(start)
    traversal_order =  []

    while queue:
        curr = queue.popleft()
        traversal_order.append(curr)

        for neighbor in graph[curr]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)
    return traversal_order

standard_result = bfs_standard(graph, 'A')
print("->".join(standard_result))


def bfs_shortest_path(graph, start, target):
    """ Shortest Path BFS Traversal (Returns shortest path sequence) """
    if start == target:
        return [start]

    visited = {start}
    queue = deque([[start]])  # Store path instead of single node
    print(f"start {queue}")
    while queue:
        path = queue.popleft()
        node = path[-1]

        for neighbor in graph[node]:
            print(f"inside for {neighbor}")
            if neighbor not in visited:
                visited.add(neighbor)
                new_path = list(path)
                new_path.append(neighbor)
                
                if neighbor == target:
                    return new_path
                
                queue.append(new_path)
        print(f" ${queue}")
        print()
    return None

path_result = bfs_shortest_path(graph, 'A', 'F')
print(' -> '.join(path_result))