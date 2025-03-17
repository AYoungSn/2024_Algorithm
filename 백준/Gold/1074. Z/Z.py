import sys
input = lambda: sys.stdin.readline().rstrip()

N, R, C = map(int, input().split())

ans = 0
while N:
  N -= 1
  if R < 2**N and C < 2 ** N:
    # 1
    ans = ans
  elif R < 2**N and C >= 2 ** N:
    # 2
    ans += 2**N * 2**N # 1번 영역 크기만큼 count 증가
    C -= 2**N # count 증가시켰으니까 열 위치 -
  elif R >= 2 **N and C < 2 ** N:
    # 3
    ans += 2**N * (2**N) * 2
    R -= 2**N
  elif R >= 2**N and C >= 2**N:
    # 4
    ans += 3*(2**(2*N)) # 2**(2*N) * 3s
    R -= 2**N
    C -= 2**N

print(ans)
