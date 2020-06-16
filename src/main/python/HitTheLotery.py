# https://codeforces.com/problemset/problem/996/A
n = int(input())

ans = 0
ans += n // 100

n %= 100
ans += n // 20

n %= 20
ans += n // 10


n %= 10
ans += n // 5

print(ans+n%5)