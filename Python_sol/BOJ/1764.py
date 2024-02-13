# https://www.acmicpc.net/problem/1764
import sys
input = sys.stdin.readline

n,m = map(int,input().split())

names_h = []
names_s =[]
for _ in range(n):
    names_h.append(input().strip())

for _ in range(m):
    names_s.append(input().strip())
final = names_h + names_s
final.sort()
# print(final) 이렇게 하면 중복되는 것이 연속적으로 나타난다.
cnt = 0
result  =[]
for i in range(len(final)-1):
    if final[i] == final[i+1]:
        result.append(final[i])
        cnt += 1
print(cnt)
for j in result:
    print(j)

'''
어떻게 풀어야할까? 방법 
1. dict방법을 사용한다.
2. 중복이 없다고 했으니 전부 합쳐서 중복이 되는 것들을 찾아 출력한다.
3. 차집합 교집합 등등을 이용하여 푼다.
'''
