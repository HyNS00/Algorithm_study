# https://www.acmicpc.net/problem/2468

import sys
sys.setrecursionlimit(10**6)

def dfs(x,y,h):
    visited[x][y] = True
    dx = [-1,0,1,0]
    dy = [0,-1,0,1]
    

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]

        if nx >= 0 and nx < n and ny >= 0 and ny < n and not visited[nx][ny] and graph[nx][ny] > h:
            dfs(nx,ny,h)

input = sys.stdin.readline
n = int(input())

graph = [list(map(int,input().split())) for _ in range(n)]
result = 0
for h in range(max(map(max,graph))+1): 
    visited = [[False]*n for _ in range(n)]  # 해당 문제에서 for문으로 반복하니까 답이 나오질 않았음 , 여러번 즉 h가 바뀔 때마다 visited가 초기화되어있는 상태로 시작해야하므로 안에 넣어준다.
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and graph[i][j] > h:
                dfs(i,j,h)
                cnt += 1

    if result < cnt :
        result = cnt 
print(result)

'''
# graph가 2차원 배열이라고 가정했을 때, map(max, graph)은 graph 리스트의 각 요소에 max함수를 적용하여 각 요소들의 최댓값을 반환하는 것
# max(map(max,graph))를 통해 각 요소들 중 완전 최대값을 반환한다.
graph =[[1, 2, 3], [4, 5, 6], [7, 8, 9]] 일 때
list(map(max,graph)) 을 실행 할시 
>> [3,6,9]가 출력된다.

'''