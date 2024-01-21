# https://www.acmicpc.net/problem/11653

import sys
input = sys.stdin.readline

n = int(input())

if n == 1:
    print('')

for i in range(2,n+1):
    if n % i == 0: # 나머지가 남지 않았을 때
        while n % i == 0:
            print(i)
            n= n/i

# while이 끝나기 전까지 i는 고정된다. 
# 즉 i는 고정한채로 n이 계속 변화하는 형식
# 소수로 남는건 사실상 fake?
