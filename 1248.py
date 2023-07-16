from collections import defaultdict

T = int(input())

for t in range(1, T+1):
    V, E, node1, node2 = map(int, input().split())
    e = list(map(int, input().split()))
    edges = defaultdict(list)
    for parent, child in zip(e[::2], e[1::2]):
        edges[parent].append(child)
    
    route1, route2 = None, None
    stack = [(1, [])]
    while stack:
        node, route = stack.pop()
        route.append(node)

        if node == node1:
            route1 = route
        elif node == node2:
            route2 = route
        
        if route1 and route2:
            break
        
        for child in edges[node]:
            stack.append((child, route[:]))
        
    # lowest common ancestor
    for node in route1[::-1]:
        if node in route2:
            lca = node
            break

    size = 0
    stack = [lca]
    while stack:
        node = stack.pop()
        size += 1
        for child in edges[node]:
            stack.append(child)

    print(f"#{t} {lca} {size}")