from collections import Counter

T = int(input())

for t in range(1, T+1):
    _ = int(input())
    score = map(int, input().split())
    answer, _ = max(Counter(score).most_common(), key=lambda x: (x[1], x[0]))

    print(f"#{t} {answer}")