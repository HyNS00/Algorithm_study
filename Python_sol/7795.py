# https://www.acmicpc.net/problem/7795
import sys
input = sys.stdin.readline




testcase = int(input())
for _ in range(testcase):
    n,m = map(int,input().split())
    a_list = list(map(int,input().split()))
    b_list = list(map(int,input().split()))
    a_list.sort()
    b_list.sort()
    cnt = 0
    result = 0
    for i in range(n):
        while True:
            if cnt == m or a_list[i] <= b_list[cnt]:
                result += cnt
                break
                
            else:
                cnt += 1

    print(result)