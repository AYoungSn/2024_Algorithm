from collections import defaultdict;
def solution(schedules, timelogs, startday):
    answer = 0
    tldict = defaultdict(list)
    startday -= 1
    for i in range(len(timelogs)):
        day = startday
        result = 0
        for d in range(7):
            if day > 4:
                day = (day + 1) % 7
                continue
            schedule = (schedules[i] // 100) * 60 + schedules[i] % 100
            timelog = (timelogs[i][d] // 100) * 60 + timelogs[i][d] % 100
            if schedule + 10 >= timelog:
                result += 1
            day = (day + 1) % 7
        if result == 5:
            answer += 1
    return answer