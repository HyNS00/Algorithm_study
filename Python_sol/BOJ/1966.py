# https://www.acmicpc.net/problem/1966
# 인덱스와 함께
import sys
input =sys.stdin.readline
from collections import deque

test= int(input())
for _ in range(test):
    n,m = map(int,input().split())
    lst = list(map(int,input().split()))
    q = deque()

    for i in range(n):
        q.append((i, lst[i]))

    cnt = 0
    while q:
        flag = True # True일 때는 출력가능/ False일 경우 배치를 안한다.
        idx,cur = q.popleft() # 맨 앞쪽부터 확인
        for i in range(len(q)):
            if cur < q[i][1]: # 우선순위가 존재하면 빠져나오지 못한다.
                flag = False
                q.append((idx,cur))
                break

        if flag:
            cnt += 1
            if idx == m:
                break
    print(cnt)
