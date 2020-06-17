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

cases =  inp()

while cases>0:
    cases-=1
    ip = inlt()

    w=ip[0]
    h=ip[1]

    ans = min(max(w+h,w),max(w+w,h),max(w,h+h))
    print(ans*ans)

