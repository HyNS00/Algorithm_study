# https://www.acmicpc.net/problem/10026

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(x,y):
    dx = [-1,0,1,0]
    dy = [0,-1,0,1]
    visited[x][y] = True 
    color = graph[x][y]
    for i in range(4):
        nx = x +dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < n: 
            if graph[nx][ny] == color and not visited[nx][ny]:
                dfs(nx,ny)

n = int(input())
graph = [list(input().strip()) for _ in range(n)]
visited = [[False]* n for _ in range(n)]
cnt = 0
cnt_2 = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            dfs(i,j)
            cnt += 1

for i in range(n):
    for j in range(n):
        if graph[i][j] == 'R':
            graph[i][j] ='G'
visited = [[False]* n for _ in range(n)]
for i in range(n):
    for j in range(n):
            if not visited[i][j]:     
                dfs(i,j)
                cnt_2 += 1

                
print(cnt,cnt_2)
