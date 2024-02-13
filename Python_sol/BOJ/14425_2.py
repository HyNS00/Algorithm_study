# 딕셔너리 방법으로 풀어보자
# https://www.acmicpc.net/problem/14425

import sys
input = sys.stdin.readline

n,m = map(int,input().split())
dic ={}
for _ in range(n):
    dic[input().strip()] = 1
cnt = 0
for _ in range(m):
    if input().strip() in dic:
        cnt += 1

print(cnt)

'''
my_dict = {'name': 'John', 'age': 25, 'city': 'New York'}

# 키 순회
for key in my_dict:
    print(key)

# 값 순회
for value in my_dict.values():
    print(value)

# 키-값 순회
for key, value in my_dict.items():
    print(key, value)

# 딕셔너리 접근
my_dict = {'name': 'John', 'age': 25, 'city': 'New York'}

print(my_dict['name'])  # 'John' 출력
print(my_dict['age'])  # 25 출력
'''

'''
my_dict = {'name': 'John', 'age': 25, 'city': 'New York'}

# 값 변경
my_dict['age'] = 30
print(my_dict)  # {'name': 'John', 'age': 30, 'city': 'New York'}

# 새로운 키-값 쌍 추가
my_dict['occupation'] = 'Engineer'
print(my_dict)  # {'name': 'John', 'age': 30, 'city': 'New York', 'occupation': 'Engineer'}

# 딕셔너리 삭제
my_dict = {'name': 'John', 'age': 25, 'city': 'New York'}

del my_dict['age']
print(my_dict)  # {'name': 'John', 'city': 'New York'}

'''