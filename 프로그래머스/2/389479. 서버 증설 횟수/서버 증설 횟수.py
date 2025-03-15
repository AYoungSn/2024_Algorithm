def solution(players, m, k):
    answer = 0
    server = 1
    servers = [1] * 24
    for i in range(len(players)):
        if players[i] < m:
            continue
        elif players[i] >= m:
            up = players[i] // m
            answer += up
            print(i, up, answer)
            end = i + k if i + k < len(players) else len(players)
            for j in range(i, end):
                players[j] -= (up * m)
            print(players)
    
    return answer