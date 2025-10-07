def solution(info, n, m):
    global answer
    answer = n
    
    visited = set()
    def dfs(i, a, b):
        global answer
        
        visited.add((i, a, b))
        if a >= n or b >= m:
            return
        if a >= answer:
            return
        if i >= len(info):
            answer = a
            return
        
        if (i + 1, a + info[i][0], b) not in visited:
            dfs(i + 1, a + info[i][0], b)
        if (i + 1, a, b + info[i][1]) not in visited:
            dfs(i + 1, a, b + info[i][1])
            
    dfs(0,0,0)
    return answer if answer < n else -1