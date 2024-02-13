class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # 투포인터로 진행을 하면서 옮겨보자
        tmp = []
        for i,n in enumerate(nums):
            tmp.append((i,n))
            
        tmp.sort(key = lambda x : x[1])
        left , right = 0, len(tmp)-1
        
        while left != right :
            if tmp[left][1] + tmp[right][1] < target:
                left += 1
            
            elif tmp[left][1] + tmp[right][1] > target:
                right -=1 

            else:
                return [tmp[left][0], tmp[right][0]]
        
        
'''
sorted(tmp, key=lambda x: x[1]) 구문. sorted 함수는 정렬된 새로운 리스트를 반환하며 원래의 리스트를 변경하지 않는다.

'''