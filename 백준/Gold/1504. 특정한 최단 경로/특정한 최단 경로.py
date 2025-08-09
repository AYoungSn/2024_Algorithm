import sys, heapq
input = lambda: sys.stdin.readline().rstrip()

N, E = map(int, input().split())
graph = [[0] * (N + 1) for _ in  range(N + 1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c

v1, v2 = map(int, input().split())

def dijkstra(s, e1, e2):
    dist = [-1] * (N + 1)
    dist[s] = 0
    que = []
    heapq.heappush(que, (0, s))
    while que:
        d, cur = heapq.heappop(que)
        if dist[cur] < d:
            continue
        for i in range(1, N + 1):
            if graph[cur][i] != 0:
                if dist[i] == -1 or dist[i] > dist[cur] + graph[cur][i]:
                    dist[i] = dist[cur] + graph[cur][i]
                    heapq.heappush(que, (dist[i], i))
    return (dist[e1], dist[e2])
path1, path2 = dijkstra(1, v1, v2)
p = dijkstra(v1, v2, 0)[0]

path3, path4 = dijkstra(N, v2, v1)
ans = path1 + path3 + p
if p < 0 or ((path1 < 0 or path3 < 0) and (path2 < 0 or path4 < 0)):
    print(-1)
else: 
    if (path1 < 0 or path3 < 0):
        ans = path2 + path4 + p
    elif ans > path2 + path4 + p:
        ans = path2 + path4 + p
    print(ans)