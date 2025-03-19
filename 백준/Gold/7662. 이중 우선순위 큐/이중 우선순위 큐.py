import sys
import heapq
from collections import defaultdict

input = lambda:sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
  K = int(input())
  min_heap = []
  max_heap = []
  nums = defaultdict(int)
  for _ in range(K):
    op, n = input().split()
    n = int(n)
    if op == 'I':
      heapq.heappush(min_heap, n)
      heapq.heappush(max_heap, (-n, n))
      nums[n] += 1
    else:
      while True:
        top = 0
        check = False
        if n == -1:
          if not min_heap:
            break
          top = heapq.heappop(min_heap)
          check = True
        else:
          if not max_heap:
            break
          top = heapq.heappop(max_heap)[1]
          check = True
        if check and nums[top] > 0:
          nums[top] -= 1
          break
  while max_heap and nums[max_heap[0][1]] <= 0:
      heapq.heappop(max_heap)
  while min_heap and nums[min_heap[0]] <= 0:
    heapq.heappop(min_heap)
  if not min_heap or not max_heap:
    print('EMPTY')
  else:
    print(max_heap[0][1], min_heap[0])