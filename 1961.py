def rotate(mat):
    N = len(mat)
    return [[mat[i][j] for i in range(N)][::-1] for j in range(N)]

T = int(input())

for t in range(1, T+1):
    N = int(input())
    # mat = [list(map(str, input().split())) for _ in range(N)]
    mat = [input().split() for _ in range(N)]

    x = rotate(mat)
    y = rotate(x)
    z = rotate(y)

    print(f"#{t}")
    for i in range(N):
        print(f"{''.join(x[i])} {''.join(y[i])} {''.join(z[i])}")