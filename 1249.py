from collections import deque

T = int(input())

for t in range(1, T+1):
    N = int(input())
    grid = [list(map(int, list(input()))) for _ in range(N)]

    distance = [[N * N for _ in range(N)] for _ in range(N)]
    queue = deque([(0, 0, 0)])

    while queue:
        x, y, dist = queue.popleft()

        if dist < distance[x][y]:
            distance[x][y] = dist
        else:
            continue

        if x - 1 >= 0 and dist + grid[x-1][y] < distance[x-1][y]:
            queue.append((x - 1, y, dist + grid[x-1][y]))
        if y - 1 >= 0 and dist + grid[x][y-1] < distance[x][y-1]:
            queue.append((x, y - 1, dist + grid[x][y-1]))
        if x + 1 < N and dist + grid[x+1][y] < distance[x+1][y]:
            queue.append((x + 1, y, dist + grid[x+1][y]))
        if y + 1 < N and dist + grid[x][y+1] < distance[x][y+1]:
            queue.append((x, y + 1, dist + grid[x][y+1]))

    print(f"#{t} {distance[-1][-1]}")