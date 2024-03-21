import sys, copy

input = lambda: sys.stdin.readline().rstrip()

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
que = []
answer = 0
total = 0
visited = [[False] * M for _ in range(N)]
for i in range(N):
  for j in range(M):
    if board[i][j] > 0 and board[i][j] < 5:
      que.append([i, j])
    elif board[i][j] == 5:
      if not visited[i][j]:
        answer += 1
        visited[i][j] = True
      for k in range(4):
        nx, ny = i, j
        while True:
          nx = nx + dx[k]
          ny = ny + dy[k]
          if nx >= 0 and ny >= 0 and nx < N and ny < M and board[nx][ny] < 6:
            if not visited[nx][ny]:
              answer += 1
              visited[nx][ny] = True
          else:
            break
    if board[i][j] != 6:
      total += 1

def dfs(idx, count, visited2):
  global answer
  if idx >= len(que):
    answer = max(answer, count)
    
    return
  cx = que[idx][0]
  cy = que[idx][1]
  cam = board[cx][cy]
  # 4 방향별로 조합 구하기
  combi = [
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 0], [3, 0, 1]]
  ]
  for lst in combi[cam - 1]:
    visit = copy.deepcopy(visited2)
    c = count
    for i in lst:
      nx, ny = cx, cy
      if not visit[nx][ny]:
        visit[nx][ny] = True
        c += 1
      while True:
        nx = nx + dx[i]
        ny = ny + dy[i]
        if nx >= 0 and ny >= 0 and nx < N and ny < M and board[nx][ny] < 6:
          if not visit[nx][ny]:
            visit[nx][ny] = True
            c += 1
        else:
          break
    dfs(idx + 1, c, visit)

dfs(0, answer, visited)
print(total - answer)