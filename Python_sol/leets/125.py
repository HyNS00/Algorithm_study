def valid_palindrome(self, s: str) -> bool: # 객체의 인스턴스 그 자체를 말한다. 즉, 객체 자기 자신을 참조하는 매개변수 
    #bool은 이 메소드가 반환하는 자료형이 bool임을 표기
    # s: str은 매개 변수 's'가 문자열 형식임을 알려준다. 
    strs = []
    for char in s:
        if char.isalnum():
            strs.append(char.lower())
            
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False
        
    return True

