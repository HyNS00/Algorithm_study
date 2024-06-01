// stack을 구현하는 예제
package doit_algorithm.chap04;

public class IntStack {
    private int[] stk;
    private int capacity;
    private int ptr;
    
    // 스택이 비어있을 경우 예외 
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){}
    }

    // 스택이 가득 찼을 경우 예외
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException(){}
    }
    public IntStack(int maxlen){
        ptr = 0;
        capacity = maxlen;
        try{
            stk = new int[capacity];
        }catch(OutOfMemoryError e){
            capacity = 0;
        }
    }

    // 스택에 푸시
    public int push(int x) throws OverflowIntStackException{
        if(ptr >= capacity){
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x; // 저장하고 ptr을 1증가
    }

    public int pop() throws EmptyIntStackException{
        if(ptr <= 0){
            throw new EmptyIntStackException();
        }
        return stk[--ptr]; // ptr값을 1감소시키고 pop
        // 왜? ptr은 들어가있는 데이터의 갯수로 인덱스로 접근하기 때문
        // 따라서 pop은 나중에 ptr이 늘어나야하고,
        // push은 먼저 ptr이 감소한다.
    }

    // peek함수는 스택이 비어있지 않다면, 스택의 꼭대기에 존재하는 요소를 반환
    public int peek() throws EmptyIntStackException{
        if(ptr <=0)
            throw new EmptyIntStackException();
        return stk[ptr -1];
    } 

    // 스택을 비운다
    // ptr은 스택이 가지고 있는 데이터의 갯수를 의미하기 때문에
    // 배열이나 데이터를 건들 필요는 없고 0으로 만들면 끝난다.
    public void clear(){
        ptr = 0;
    }

    // 스택에서 index를 찾아 반환 , 없다면 -1
    public int indexOf(int x){
        for(int i = ptr -1; i >= 0; i--){
            if(stk[i] == x){
                return i;
            }
        }
        return -1;
    }
    
    // 스택에 있는 데이터 개수 반환
    public int size(){
        return ptr;
    }

    // 스택이 비어있는 유무
    public boolean isEmpty(){
        return ptr <= 0;
    }

    // 스택이 가득 차있는지 여부
    public boolean isFull(){
        return ptr >= capacity;
    }

    public void dump(){
        if(ptr <= 0){
            System.out.println("스택이 비어있습니다");
        }
        else{
            for (int i = 0; i < ptr; i++){
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }

    // 스택의 용량을 반환
    public int getCapacity(){
        return capacity;
    }


}
