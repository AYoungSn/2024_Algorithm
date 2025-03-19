import sys
from collections import deque

input = lambda: sys.stdin.readline().rstrip()
T = int(input())
def bfs(A, B):
    que = deque()
    que.append((A, ''))
    visited = [0] * 10000
    visited[A] = 1
    while que:
        cur, command = que.popleft()
        if cur == B:
            print(command)
            break
        tmp = (cur * 2) % 10000
        if visited[tmp] == 0:
            visited[tmp] = 1
            que.append((tmp, command + 'D'))
        tmp = cur - 1
        if cur == 0:
            tmp = 9999
        if visited[tmp] == 0:
            visited[tmp] = 1
            que.append((tmp, command + 'S'))
        tmp = (cur % 1000) * 10 + cur // 1000
        if visited[tmp] == 0:
            visited[tmp] = 1
            que.append((tmp, command + 'L'))
        tmp = (cur % 10) * 1000 + (cur // 10)
        if visited[tmp] == 0:
            visited[tmp] = 1
            que.append((tmp, command + 'R'))

for _ in range(T):
    A, B = map(int, input().split())
    bfs(A, B)