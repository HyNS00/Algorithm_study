# https://www.acmicpc.net/problem/11399

import sys
input = sys.stdin.readline

n = int(input())
# 각 사람이 인출하는데 걸리는 시간이 pi로 제출
'''
1 3
2 1
3 4
4 3 
5 2
 인덱스랑 같이 받아볼까?
 min값을 해서 그리디로 해야할 것 같다
cl
'''
result = 0
people = list(map(int,input().split()))
people.sort()

for i in range(1,n+1):
    result += sum(people[0:i])

print(result)
