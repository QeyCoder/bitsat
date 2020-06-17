import sys

input = sys.stdin.readline


def inp():
    return int(input())


def inlt():
    return list(map(int, input().split()))


def insr():
    s = input()
    return list(s[:len(s) - 1])


def invr():
    return map(int, input().split())


def inBw(l, r):
    lf = l + 1
    rt = r - k - 1
    return (rt - lf + 1) // (k + 1)


def solve(arr, k):
    store = []
    for i, v in enumerate(arr):
        if v == '1':
            store.append(i)

    if len(store) == 0:
        return (len(arr) - 1) // (k + 1) + 1
    ans = 0
    n = len(arr)
    start = store[0]
    end = store[len(store) - 1]

    ans += start // (k + 1)
    ans += (n - 1 - end) // (k + 1)

    for x in range(1, len(store)):
        ans += inBw(store[x - 1], store[x])
    return ans


n = inp()
while n > 0:
    n -= 1
    ip = inlt()
    m = ip[0]
    k = ip[1]
    arr = insr()
    print(solve(arr, k))
