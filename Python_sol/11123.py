# https://www.acmicpc.net/problem/11123

import sys
input = sys.stdin.readline
'''
현재 h가 행의 역할을, w가 열의 역할을 한다
그러나 x는 가로이므로 w, y는 세로이므로 h
그래서 앞뒤로y,w를 바꿔서 진행해주어야한다.
'''
sys.setrecursionlimit(10**6)
def DFS(y,x):
    graph[y][x] = '.'
    dx =[0,-1,0,1]
    dy =[-1,0,1,0]

    for k in range(4):
        ny = y+dy[k]
        nx = x+dx[k]

        if ny >= 0 and ny < h and nx >= 0 and nx < w:
            if graph[ny][nx] == '#':
                DFS(ny,nx)

testcase = int(input())
for _ in range(testcase):
    h,w = map(int,input().split())
    graph =[list(input().rstrip()) for _ in range(h)] 
    # graph =[[input().rstrip().split()] for _ in range(h)]  # 실수를 저질렀다.
    cnt = 0

    for i in range(h):
        for j in range(w):
            if graph[i][j] == '#':
                DFS(i,j)
                cnt += 1

    print(cnt)

'''
graph를 사용 할 때
초기에 작성한 코드는 graph =[[input().rstrip()] for _ in range(h)]였다.
하지만 그렇게 된다면 오른쪽 공백을 제거한 뒤 입력한 값들이 합쳐서서 list를 구성한다 ex [['#.#.'],['.#.#'] ...] -> len(1)

따라서 list함수를 이용해서 grpah를 만들어줘야 len(4)인 그래프가 만들어진다

'''