# https://www.acmicpc.net/problem/2503

import sys
from itertools import permutations
input = sys.stdin.readline

n = int(input())
num = list(permutations([1,2,3,4,5,6,7,8,9], 3))
for _ in range(n):
    test,strike,ball = map(int,input().split())
    test = list(str(test))
    remove_cnt =0
    for i in range(len(num)):
        s_cnt = 0
        b_cnt =0
        i -= remove_cnt # 줄어든 인덱스에 대한 조정

        for j in range(3): # 돌면서 확인
            test[j] =int(test[j])
            if test[j] in num[i]:
                if j == num[i].index(test[j]): # 인덱스 값을 비교, 해당 숫자가 해당 인덱스에 존재하는가?
                    s_cnt += 1

                else :
                    b_cnt +=1

        if s_cnt != strike or b_cnt !=ball:
            num.remove(num[i])
            remove_cnt += 1


print(len(num))