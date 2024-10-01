import sys

input = lambda: sys.stdin.readline().rstrip()

N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))
res = []
while True:
    tmp1, tmp2 = max(A), max(B)
    idx1, idx2 = A.index(tmp1), B.index(tmp2)
    if tmp1 == tmp2:
        res.append(tmp1)
        A, B = A[idx1 + 1:], B[idx2 + 1:]
    elif tmp1 > tmp2:
        A.pop(idx1)
    else:
        B.pop(idx2)
    if not A or not B:
        break

print(len(res))
print(*res, sep=' ')
