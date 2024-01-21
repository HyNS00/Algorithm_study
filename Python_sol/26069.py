# https://www.acmicpc.net/problem/26069

import sys

input = sys.stdin.readline

n = int(input())
party = ['ChongChong']


for _ in range(n):
    a,b= input().strip().split(' ')
    if a in party:
        party.append(b)
    elif b in party:
        party.append(a)

print(len(set(party)))

# print(party)
# 항상 어딜봐야할까 
# print(result)