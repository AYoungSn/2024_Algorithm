from collections import deque

def solution(land):
    answer = 0
    visited = [[False] * len(land[0]) for _ in range(len(land))]
    cost = [0] * len(land[0])
    for i in range(len(land)):
        for j in range(len(land[0])):
            if not visited[i][j] and land[i][j] == 1:
                bfs(i, j, land, visited, cost)
    return max(cost)

def bfs(r, c, land, visited, cost):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    que = deque()
    que.append((r,c))
    cols = set()
    cols.add(c)
    visited[r][c] = True
    cnt = 1
    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and ny >= 0 and nx < len(land) and ny < len(land[0]) \
                and not visited[nx][ny] and land[nx][ny] == 1:
                cnt += 1
                cols.add(ny)
                visited[nx][ny] = True
                que.appendleft((nx, ny))
    for col in cols:
        cost[col] += cnt
                