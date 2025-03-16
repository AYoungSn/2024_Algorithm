import sys

input = lambda: sys.stdin.readline().rstrip()
N, S = map(int, input().split())
arr = list(map(int, input().split()))

start = 0
end = 0
subsum = 0
min_num = N + 1
while True:
  if subsum >= S:
    min_num = min(min_num, end - start)
    subsum -= arr[start]
    start += 1
  elif end >= N:
    break
  else:
    subsum += arr[end]
    end += 1
  


if min_num == N + 1:
  print(0)
else:
  print(min_num)