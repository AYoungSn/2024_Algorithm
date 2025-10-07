def solution(today, terms, privacies):
    answer = []
    ty, tm, td = map(int, today.split('.'))
    tdict = {}
    for term in terms:
        a, b = term.split()
        tdict[a] = int(b)
    for i in range(len(privacies)):
        day, term = privacies[i].split()
        y, m, d = map(int, day.split('.'))
        if y * 12 + m + tdict[term] < ty * 12 + tm:
            answer.append(i + 1)
        elif y * 12 + m + tdict[term] == ty * 12 + tm:
            if d <= td:
                answer.append(i + 1)
            
        
        
    return answer