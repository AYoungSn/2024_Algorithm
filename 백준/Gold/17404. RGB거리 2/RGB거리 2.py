import sys
input = lambda:sys.stdin.readline().rstrip()

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

def solve(dp):
  for i in range(1, N):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2]

res = 1000000

for i in range(3):
  dp = [[1001] * 3 for _ in range(N)]
  dp[0][i] = arr[0][i]
  solve(dp)
  dp[-1][i] = 1000000
  res = min(res, min(dp[-1]))

print(res)


