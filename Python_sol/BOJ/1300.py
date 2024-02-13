# https://www.acmicpc.net/problem/1300
import sys

input = sys.stdin.readline

n = int(input())

a = [[0]*(n+1) for i in range(n+1)]

for i in range(1,n+1):
    for j in range(1,n+1):
        a[i][j] = i*j

k = int(input())

