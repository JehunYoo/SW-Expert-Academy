from collections import defaultdict

T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())
    linked = defaultdict(list)
    for _ in range(M):
        p1, p2 = map(int, input().split())
        linked[p1].append(p2)
        linked[p2].append(p1)

    answer = 0
    visited = [False for _ in range(N+1)]

    for person in range(1, N+1):
        if not visited[person]:
            answer += 1
            stack = [person]
            while stack:
                p = stack.pop()
                if not visited[p]:
                    visited[p] = True
                    for q in linked[p]:
                        if not visited[q]:
                            stack.append(q)

    print(f"#{t} {answer}")