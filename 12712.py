T = int(input())

for t in range(1, T+1):
    N, M = map(int, input().split())
    area = [list(map(int, input().split())) for _ in range(N)]
    answer = 0

    for i in range(N):
        for j in range(N):
            # '+'
            catch = area[i][j]

            for m in range(1, M):
                if i - m >= 0:
                    catch += area[i - m][j]
                if i + m < N:
                    catch += area[i + m][j]
                if j - m >= 0:
                    catch += area[i][j - m]
                if j + m < N:
                    catch += area[i][j + m]
            
            answer = max(answer, catch)

            # 'x'
            catch = area[i][j]

            for m in range(1, M):
                if i - m >= 0 and j - m >= 0:
                    catch += area[i - m][j - m]
                if i - m >= 0 and j + m < N:
                    catch += area[i - m][j + m]
                if i + m < N and j - m >= 0:
                    catch += area[i + m][j - m]
                if i + m < N and j + m < N:
                    catch += area[i + m][j + m]
            
            answer = max(answer, catch)
            

    print(f"#{t} {answer}")