from collections import deque

def solution(storage, requests):
    answer = 0
    storage = [list('0'+storage[i]+'0') for i in range(len(storage))]
    m = len(storage[0])
    storage.insert(0, ['0'] * m)
    storage.append(['0'] * m)
    n = len(storage)
    
    # 0 : 외부, 1: 빈 공간
    
    for req in requests:
        if len(req) == 1:
            answer += jige(storage, req, n, m)
        else:
            answer += crain(storage, req,  n, m)
    return (n-2) * (m-2) - answer

def crain(storage, req, n, m):
    # 다 꺼내기
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    cnt = 0
    print('crain', req)
    for i in range(1, n -1):
        for j in range(1, m-1):
            # print('storage[', i, '][',j,']', storage[i][j], ', req:',req[0])
            if storage[i][j] == req[0]:
                cnt += 1
                storage[i][j] = '1'
                isOutSide(storage, i, j, n, m)
    # print('storage', storage)
    return cnt

def jige(storage, req, n, m):
    # 외부와 닿아있는 것만 꺼내기
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    cnt = 0
    print('jige', req)
    que = deque()
    for i in range(1, n -1):
        for j in range(1, m-1):
            if storage[i][j] == req:
                for k in range(4):
                    nx = dx[k] + i
                    ny = dy[k] + j
                    if storage[nx][ny] == '0':
                        cnt += 1
                        que.append((i, j))
                        break
    while len(que) > 0:
        cx, cy = que.popleft()
        storage[cx][cy]='0'
        isOutSide(storage, cx, cy, n, m)
    return cnt

def isOutSide(storage, x, y, n, m):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    visited = [[0] * m for _ in range(n)]
    que = deque([(x, y)])
    while len(que)>0:
        cx, cy = que.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if storage[nx][ny] == '0':
                storage[cx][cy] = '0'
                break
        if storage[cx][cy] == '0':
            for i in range(4):
                nx = dx[i] + cx
                ny = dy[i] + cy
                if storage[nx][ny] == '1':
                    storage[nx][ny] = '0'
                    que.append((nx, ny))
                
    
    