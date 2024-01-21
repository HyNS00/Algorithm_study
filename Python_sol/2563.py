# https://www.acmicpc.net/problem/2563

# import sys

# input = sys.stdin.readline

# n = int(input())
# '''
# 3 7
# 어쨌든 모든 색종이는 10 * 10
# 3 7

# 5* 8 = 40
# 40 +120 + 100
# 260
# 혹은 300 - 40 = 260
# '''


# # 어떻게 접근하는 것이 좋을까???
# # 튜플로 받는다?

# papers = []
# for _ in range(n):
#     a,b = map(int,input().split())
#     papers.append((a,b))
# sames = []
# # a는 가로가 시작하는 점 , b는 새로가 시작하는 점
# for i in range(n-1):
#     for j in range(i+1,n):
#     # 겹치는 것을 도와준다..
#     # 겹치는 부분을  구해보자
#     # 겹칠 때 어떻게 실행을 해야할까?
#     # 3 ~ 13 /15 ~ 25/ 5~ 15/
#         if papers[i][0] - papers[j][0] < 10:
#             s1 = 10 - abs(papers[i][0]-papers[j][0])
#             s2 = 10 -abs(papers[i][1] -papers[j][1])
#             if s1 > 0 and s2 >0 :
#                 sames.append((s1,s2))

# r = 0
# for j in sames:
#     k = j[0]*j[1]
#     r += k

# final = n*100 - r
# print(final)

'''
겹치는 영역을 전부 빼주는 역할을 한다면 모든 좌표가 같은 경우에 대해 예외를 둘 수 없다.
접근과 문제 풀이방법은 좋았으나 예외처리 사항을 할 수 없었다.

그렇다면 문제 어떻게 접근을 해야할까?
전체 영역에서 해당하거나/ 겹치는 부분에 대해 값을 구해주는 것이 가장 나은 방법이다.
'''
import sys
input = sys.stdin.readline

canvas = [[0]* 101 for _ in range(101)]
n = int(input())

for _ in range(n):
    a,b = map(int,input().split())

    for i in range(a,a+10):
        for j in range(b,b+10):
            canvas[i][j] = 1

cnt = 0
for paper in canvas:
    cnt += paper.count(1)

print(cnt) 