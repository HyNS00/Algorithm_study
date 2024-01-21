# https://www.acmicpc.net/problem/1213
'''
from collections import Counter

collections 모듈에서 Counter 클래스를 가져온다
Counter 클래스는 반복가능한(iterable)객체에서 요소의 빈도를 계산하는데 사용된다.

Counter객체는 각 요소의 개수를 딕셔너리 형태로 저장하며, 요소를 key로 사용하고 해당
요소의 개수를 값(value)으로 표현한다
이를 통해 요소의 빈도를 확인하거나 요소 간의 상대적인 빈도를 비교할 수 있다.
from collections import Counter

text = "Hello, World!"
counter = Counter(text)

print(counter)

출력은 
Counter({'l': 3, 'o': 2, 'H': 1, 'e': 1, ',': 1, ' ': 1, 'W': 1, 'r': 1, 'd': 1, '!': 1})

'''
import sys
from collections import Counter # 이번엔 Counter 활용
'''
평범한 딕셔너리를 활용한다면?
d = dict()
test = input().strip()
for i in test:
    if d.get(i) == None :
        d[i] = 1
    else :
        d[i] += 1

'''
input = sys.stdin.readline

test = list(map(str,input().strip())) # 이렇게 받는 것 또한 하나의 팁 , 문자열을 리스트로 받아보자
# test = input()이렇게 받아도 되지만 나중에 활용하기 힘들다
test.sort() # 답이 여러개인 경우 사전순으로 출력을 해야하니 sort()를 해준다.
counter = Counter(test)
odd = 0 # 홀수를 받는 변수
odd_alpha = '' # 가운데 있는 알파벳을 받는 변수
ans ='' # 답을 받는 변수

for i in counter:
    if counter[i] %2 != 0:
        odd += 1 # 나눴을 때 2개이상이면 홀수를 하나늘리고
        odd_alpha += i # 가운데에 올 알파벳을 하나 추가

    for _ in range(counter[i]//2): 
        ans += i # 나눠지는 수 만큼 짝수는 더해준다.

if odd > 1:
    print("I'm Sorry Hansoo")
elif odd == 0:
    print(ans + ans[::-1])

else :
    print(ans + odd_alpha + ans[::-1])


