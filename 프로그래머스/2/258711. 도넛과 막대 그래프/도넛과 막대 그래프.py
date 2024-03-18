from collections import defaultdict

def solution(edges):
    answer = [0,0,0,0]
    # 추가된 정점 특징: 나가는 간선 2 이상, 들어오는 간선 0
    graph = dict() # key -> v, v,
    # in_graph = defaultdict(list) # key <- v,v,
    for a, b in edges:
        if not graph.get(a):
            graph[a] = [0,0]
        if not graph.get(b):
            graph[b] = [0,0]
        graph[a][0] += 1
        graph[b][1] += 1
        # in_graph[b].append(a)
    # 생성한 정점 번호 찾기
    for node in graph.keys():
        if graph[node][0] >= 2 and graph[node][1] == 0:
            answer[0] = node
        elif graph[node][0] == 0 and graph[node][1] >= 1:
            # 막대 모양 그래프 찾기
            # 막대 모양 그래프: out 0, in 1
            answer[2] += 1
        elif graph[node][0] == 2 and graph[node][1] >= 2:
            # 8자 모양 그래프 : out 2, in > 2
            answer[3] += 1
    answer[1] = graph[answer[0]][0] - answer[2] - answer[3]
    return answer
