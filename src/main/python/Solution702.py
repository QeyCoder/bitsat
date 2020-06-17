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


def solve(ip):
    i = 0
    j = i + 1
    max = 1

    while (i <= j) and j < len(ip):
        current = 1
        while i < j < len(ip) and (ip[i] < ip[j]) :
            current = current + 1
            j = j + 1
            i = i+1
        if current > max:
            max = current
        i = i + 1
        j = j + 1
    print(max)


n = inp()
ip = inlt()
solve(ip)
