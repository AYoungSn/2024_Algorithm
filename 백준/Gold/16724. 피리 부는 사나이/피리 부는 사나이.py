import sys
input = lambda:sys.stdin.readline().rstrip()

N,M = map(int, input().split())
arr = [list(map(str, input())) for _ in range(N)]
visit = [[-1 for _ in range(M)] for _ in range(N)]

direction = {
    'L': (0, -1),
    'R': (0, 1),
    'U': (-1, 0),
    'D': (1, 0)
}
dx = [0,0,-1,1]
dy = [-1,1,0,0]

def move(x,y,idx):
    global answer
    if visit[x][y] != -1:
        if visit[x][y] == idx:
            answer += 1
        return
    visit[x][y] = idx
    move(x + direction[arr[x][y]][0], y + direction[arr[x][y]][1], idx)

idx = 0
answer = 0
for n in range(N):
    for m in range(M):
        if visit[n][m] == -1:
          move(n,m,idx)
          idx += 1

print(answer)