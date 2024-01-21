# https://www.acmicpc.net/problem/13305

import sys
input = sys.stdin.readline

n = int(input())
rail = list(map(int,input().split()))
cost= list(map(int,input().split()))

min_cost = cost[0]
answer = 0
for i in range(n-1):
    if min_cost > cost[i]:
        min_cost = cost[i]
    answer += min_cost * rail[i]
# 꼭 dp여도 dp list를 만들 필요는 없다
print(answer)