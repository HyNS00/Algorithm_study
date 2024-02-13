from typing import List
# 하나씩 찾는거보단 나머지 값을 찾는 방법
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 리스트에 있는 값을 기준으로 나머지 값이 있는지 탐색
        for i,n in enumerate(nums):
            value = target - n # target에서 뺸 나머지값
            
            if value in nums[i+1 :]:  # 나머지 값이 기준 인덱스 다음부터 존재할 경우
                return [nums.index(n), nums[i+1:].index(value)+(i+1)]
            # return값을 nums.index(value)는 맞다
            # 그러나 nums[i+1:].index(value)+(i+1)를 해야하는 이유 
            '''
            [3,3] target = 6일 경우
            nums[i+1:] -> [3]이므로 index 값 자체는 0이다.
            근데 output이 전체 input기준임으로 그만큼 더해줘야한다(i+1)
            
            '''
            
