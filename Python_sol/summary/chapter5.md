# 5장 
## 리스트, 딕셔너리

### 리스트

| 연산             | 시간 복잡도       | 설명                                             |
|------------------|------------------|--------------------------------------------------|
| len(a)           | O(1)             | 전체 요소의 개수를 리턴한다.                      |
| a[i]             | O(1)             | 인덱스 i의 요소를 가져온다.                       |
| a[i:j]           | O(k)             | i부터 j-1까지의 슬라이스 길이 k                    |
| elem in a        | O(n)             | elem라는 요소가 있는지 확인, 처음부터 순차적으로 탐색 |
| a.count(elem)    | O(n)             | elem 요소의 개수를 리턴                           |
| a.index(elem)    | O(n)             | elem요소의 인덱스를 리턴                          |
| a.append(elem)   | O(1)             | 리스트 마지막에 elem요소를 추가                   |
| a.pop()          | O(1)             | 리스트 마지막 요소를 추출한다.                    |
| a.pop(0)         | O(n)             | 리스트 첫번 째 요소를 추출, 큐의 연산              |
| del a[i]         | O(n)             | i에 따라 다르다, 최악의 경우 O(n)                   |
| a.sort()         | O(n log n)       | 정렬, 최선의 경우 O(n)                            |
| min(a), max(a)   | O(n)             | 최댓값, 최솟값을 계산하기 위해 전체 선형 탐색        |
| a.reverse()      | O(n)             | 뒤집는다. 입력순서가 유지되므로 입력순서 반대        |


리스트는 객체로 되어 있는 모든 자료형을 포인터로 연결한다.
따라서 파이썬의 리스트는 배열과 연결 리스트를 합친 듯이 강력한 기능을 자랑한다.

일반적으로 정수형 배열이라고 한다면, 정수로만 이뤄진 값을 연속된 메모리 공간에 저장하는 경우를 말한다. 파이썬 리스트는 연결 리스트에 대한 __포인터__ 목록을 관리하고 있기 때문에 다양한 타입을 동시에 단일 리스트에서 관리하는 게 가능하다.  

```python
a = [1,2,3]
>> a 
[1,2,3]

a = [1,'안녕', True]
>> a
[1,'안녕', True]
```  

<br/>
  
---

### 딕셔너리

파이썬의 딕셔너리는 키/값 구조로 이뤄진 딕셔너리를 말한다.  
내부적으로는 해시 테이블로 구현되어 있다.  


| 연산               | 시간 복잡도 | 설명                               |
|-------------------|------------|------------------------------------|
| len(a)            | O(1)       | 요소의 개수를 리턴한다.              |
| a[key]            | O(1)       | 키를 조회하여 값을 리턴한다.          |
| a[key] = value    | O(1)       | 키/값을 삽입한다.                    |
| key in a          | O(1)       | 딕셔너리에 키가 존재하는지 확인한다.  |  


<br/>

```python

# 딕셔너리의 활용
a = dict() # 또는 a ={}

a ={'key1' :'value1' ,'key2' : 'value2' ,'key3':'value3'}
# my_dict = {'key1': 123, 'key2': 456, 'key3': 789}
# my_dict = {1: 'one', 2: 'two', 3: 'three'}

# 존재 여부 확인
if 'key1' in my_dict:
    print('key1 exists in the dictionary')

# 딕셔너리 메소드
keys = my_dict.keys()
values = my_dict.values()
items = my_dict.items()

.keys(): 딕셔너리의 모든 키를 반환합니다.
.values(): 딕셔너리의 모든 값을 반환합니다.
.items(): 딕셔너리의 모든 키-값 쌍을 반환합니다.

```

```python
# 유용한 클래스 Counter
from collections import Counter

my_list = [1, 2, 3, 1, 2, 3, 1, 2, 1, 2, 3, 4, 5]
my_counter = Counter(my_list)

print(my_counter)  # Counter({1: 4, 2: 4, 3: 3, 4: 1, 5: 1})

# 가장 빈번한 2개의 항목과 개수 출력
print(my_counter.most_common(2))  # [(1, 4), (2, 4)]

# 다른 iterable에서 항목 빼기
other_list = [1, 2, 3]
my_counter.subtract(other_list)
print(my_counter)  # Counter({1: 3, 2: 2, 3: 2, 4: 1, 5: 1})

```