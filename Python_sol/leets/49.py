# https://leetcode.com/problems/group-anagrams/description/

from typing import List
from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 출력을 보아하니 같은 형식끼리 묶여있다. -> 딕셔너리 사용을 해야할 것같다
        # output결과를 보니 n > t, a > e > t 순으로 알파벳 순
        # 결국에는 재조립을 어떻게하는가? 이게 중요해보인다.
        # 기준을 잡고 나머지를 어떻게 변경 시켜야할까??
        # string을 sorted 함수에 넣으면 list로 반환
        answer  = defaultdict(list)
        for str in strs:
            grouping = sorted(str)
            answer[''.join(grouping)].append(str)
            
        return list(answer.values())
            
        
# a = "str"
# print(sorted(a))
# print(''.join(sorted(a)))

k = defaultdict(list)

k[3].append(5)
k[3].append(4)
print(list(k.values()))