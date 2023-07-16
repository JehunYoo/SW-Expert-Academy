T = int(input())

for t in range(1, T+1):
    N = int(input())
    board = [list(input()) for _ in range(N)]
    mine = '*'
    danger = 0 # count if there is a mine nearby

    for i in range(N):
        for j in range(N):
            if board[i][j] == mine:
                continue
            count = 0

            up, down = i - 1, i + 1
            left, right = j - 1, j + 1
            cond_up, cond_down = up >= 0, down < N
            cond_left, cond_right = left >= 0, right < N

            box = [
                ([cond_left], i, left),
                ([cond_up, cond_left], up, left),
                ([cond_up], up, j),
                ([cond_up, cond_right], up, right),
                ([cond_right], i, right),
                ([cond_down, cond_right], down, right),
                ([cond_down], down, j),
                ([cond_down, cond_left], down, left)
            ]

            for cond, a, b in box:
                if all(cond) and board[a][b] == mine:
                    count += 1
            
            board[i][j] = count
            if count > 0:
                danger += 1

    # DFS, find 0 groups
    zeros = 0
    border = 0
    visited = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if board[i][j] == 0 and not visited[i][j]:
                zeros += 1
                stack = [(i, j)]
                
                while stack:
                    x, y = stack.pop()
                    if not visited[x][y]:
                        visited[x][y] = True

                        up, down = x - 1, x + 1
                        left, right = y - 1, y + 1
                        cond_up, cond_down = up >= 0, down < N
                        cond_left, cond_right = left >= 0, right < N

                        box = [
                            ([cond_left], x, left),
                            ([cond_up, cond_left], up, left),
                            ([cond_up], up, y),
                            ([cond_up, cond_right], up, right),
                            ([cond_right], x, right),
                            ([cond_down, cond_right], down, right),
                            ([cond_down], down, y),
                            ([cond_down, cond_left], down, left)
                        ]

                        for cond, a, b in box:
                            if all(cond) and board[a][b] != mine and board[a][b] > 0 and not visited[a][b]:
                                border += 1
                                visited[a][b] = True
                            if all(cond) and board[a][b] == 0 and not visited[a][b]:
                                stack.append((a, b))

    answer = zeros + (danger - border)

    print(f"#{t} {answer}")