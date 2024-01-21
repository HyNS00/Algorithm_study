# https://www.acmicpc.net/problem/5545

import sys
input = sys.stdin.readline

n = int(input())

a,b = map(int,input().split())
c = int(input())

kcal = []
for _ in range(n):
    kcal.append(int(input()))
kcal.sort(reverse= True) # 내림 차순으로 정렬한다 왜?
# 내림차순으로 정렬해야 여러번 계산할 필요가 없다. 어차피 갯수가 많아질 수록 분모가 커져 수가 작아질 수도 있고, 우리는 가장 큰 값을 구하는 것으로
# 분모는 가장 작게(토핑수 적게), 분자는 가장크게(토핑 칼로리 가장 큰 값) 이 필요하므로 그냥 큰 내림차순으로 정렬

dough = c
price = a
result = dough/price
for i in range(n):
   tmp = (dough + kcal[i]) / (price+b) # 토핑을 추가했을 때의 칼로리 비율
   if tmp >= result: # 현재 최대 칼로리 비율 result가 크거나 같으면 result를 tmp로 대체
       result = tmp
       dough += kcal[i]
       price += b
   else:
       break
   
print(int(result))

