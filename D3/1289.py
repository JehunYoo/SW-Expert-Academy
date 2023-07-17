T = int(input())
for t in range(1, T + 1):
    target = input()
    count = 0
    prev = None
    for bit in target:
        if (prev is None and bit == '0') or prev == bit:
            continue
        else:
            count += 1
        prev = bit

    print(f"#{t} {count}")