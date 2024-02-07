# https://leetcode.com/problems/reorder-data-in-log-files/description/
'''
기준에 따라 분류를 하는 문제, 어떻게 깔끔하게 기준을 나누고 분류를 진행해야할지 고민을 해봤다.
'''
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digits,letters=[],[] # 숫자인 로그와 문자인 로그를 따로따로 담을 수 있는 빈 리스트를 생성
        for log in logs:
            if log.split()[1].isdigit(): # 공백을 기준으로 split을 한 다음 .isdigit()을 사용해서 숫자면 digits에 
                digits.append(log)
            else:
                letters.append(log) # 문자라면 letters
                
        letters.sort(key = lambda x : (x.split()[1:], x.split()[0])) 
        # 정렬을 할 때, 분류가 기준이 되는 문자열을 우선으로 하고 그 다음, 겹친다면, 구분자로 진행할 수 있게 해봤다.
        return letters + digits
        # 여기서 생각보다 숫자를 어떻게 이어질 수 있게 고민을 많이 해봤는데, 그냥 digits리스트에 담긴 그대로 붙이면 된다.
        

                
        
