from collections import deque

T = int(input())
for t in range(1, T + 1):
    N, L = map(int, input().split())
    data = sorted([tuple(map(int, input().split())) for _ in range(N)], key=lambda x: x[1])
    data = [(i, food, cal) for i, (food, cal) in enumerate(data)]
    
    queue = deque(data)
    answer = 0
    while queue:
        i, food, cal = queue.popleft()
        for j in range(i + 1, N):
            if cal + data[j][2] <= L:
                queue.append((j, food + data[j][1], cal + data[j][2]))
        if cal <= L:
            answer = max(answer, food)

    print(f"#{t} {answer}")