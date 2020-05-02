# DCP 379
# Given a string, generate all possible subsequences of the string.

# For example, given the string xyz, return an array or set with the following strings:
#
#
# x
# y
# z
# xy
# xz
# yz
# xyz
def solution(ip, ans):
    if len(ip) == 0:
        print(ans)
        return
    solution(ip[1:], ans)
    solution(ip[1:], ans + ip[0])

def main():
    ip = 'xyz'
    solution(ip, '')


if __name__ == '__main__':
    main()

