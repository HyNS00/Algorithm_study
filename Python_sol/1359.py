# https://www.acmicpc.net/problem/1359
import sys
from itertools import combinations
input = sys.stdin.readline
n,m,k = map(int,input().split())
a = list(combinations(range(1,n+1),m))
b = list(combinations(range(1,n+1),m))
cnt = 0
# # 같은 수가 k개다
wow = 0
h =0
for sample in a:
    for result in b:
       h += 1
       cnt = 0
       for i in range(m):
            for j in range(m):
                if sample[i] == result[j]:
                    cnt +=1
       if cnt >= k:
            wow += 1
print(wow/len(a)**2)



# for sample in a:
#     for result in b:
#         wow += 1
#         if len(set(sample) & set(result)) >= k:
#             cnt += 1
# print(float(cnt/wow))
# print(wow)
# print(cnt)
