# https://www.acmicpc.net/problem/3273

import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int,input().split()))
x = int(input())

lst.sort()
start = 0
end = n-1
cnt = 0

while start < end:
    tmp = lst[start] + lst[end]
    if tmp == x :
        cnt += 1
        # 딱 알맞으면 바로 시작
    if tmp < x:
        start += 1
        # 크기가 모자라다면 숫자를 키워줘야한다
        continue
    #크기가 크다면 end값을 줄여줘야한다. 계속해서 하나만 줄여준다. 
    # end값을 지속해서 줄여줌
    end -= 1

print(cnt)
