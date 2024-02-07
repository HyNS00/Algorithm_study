# https://leetcode.com/problems/reorder-data-in-log-files/description/

class Solution:
    def recorderLogFiles(self, logs: List[str]) -> List[str]:
        # 어떻게 구분해야할까
        # 튜플로 구분한다 했을 때, 0,1을 부여해서 구분해보자
        def sorting_algorithm(log):
            left_side, right_side = log.split(" ",1)
            # 구분을 했다, 그렇다면 0과1을 어떻게 부여할거지?
            
            if right_side[0].isalpha(): # left_side가 영문자 -> 0
                # .isalpha()를 문자열에 쓰려면 문자열 전체에 공백이 있거나 하면 안된다.
                return (0, right_side, left_side)
            else : # 숫자일 경우 -> 1
                return (1,) # 이렇게 한 이유는 입력순서를 유지하기 위함함
            
        return sorted(logs, key = sorting_algorithm)

#           
# test = "let1 art can"
# print(test.split(" ",1))

# k,p = test.split(" ",1)
# print(k,p)
# print(p.is)