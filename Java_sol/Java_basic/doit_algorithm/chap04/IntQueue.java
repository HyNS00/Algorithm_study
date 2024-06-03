// 링버퍼를 활용한 큐 
// 배열을 이용해서 만들 경우, 디큐를 할 때마다 요소들의 인덱스들을 옮겨줘야하므로 복잡도가 O(n)이 나온다.
// 이를 해결하기 위해 "링버퍼" 사용  
// 처음과 끝이 연결되어 있는 것처럼 동작하여, 버퍼의 끝에 도달하면 다시 처음으로 돌아가서 데이터를 덮어써 요소 이동 문제 해결
// 논리적인 첫 인덱스 역할을 하는 front와 논리적인 끝 인덱스 역할을 하는 rear를 사용하여 엎데이트해가며 진행
// 복잡도 O(1)

package doit_algorithm.chap04;

public class IntQueue {
    private int[] que; // 큐용 배열
    private int capacity; // 큐의 용량
    private int front; // 맨 앞의 인덱스
    private int rear; // 맨 끝의 인덱스
    private int num;  // 현재 데이터 개수

    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }

    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    public IntQueue(int maxlen){
        num = front = rear = 0;
        // num이 필요한 이유🤓
        // front값과 rear값이 같을 때, 큐가 비어있는지, 가득 찼는지 확인하기 위해 
        // num은 말 그대로 현재의 데이터 갯수를 나타내므로, 0이라면 비어있는거고, capacity값이라면 가득 차있는 것.
        capacity = maxlen;

        try{
            que = new int[capacity];

        }catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException{
        if(num >= capacity){
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if(rear == capacity){
            rear = 0;
        } // 배열에 데이터가 전부 들어가 있는 것이 아닌, 일부만 꽉차있는데 인덱스 값만 capacity와 같을 경우, 
        //  0으로 보내서 잘못된 인덱스 값을 가리키지 않게 만듦
        return x;
    } // 위치에 상관없이 가라키는 것

    public int deque() throws EmptyIntQueueException{
        if (num <= 0){
            throw new EmptyIntQueueException();
        }
        int x = que[front++]; // 왜 ++을 할까? -> front가 원래 가리키고 있던 값을 내보내고 그 다음 인덱스로 옮겨가기 위해서
        num--;
        if (front == capacity){
            front = 0;
        } // 여기서도 잘못된 인덱스 , 즉 capacity를 넘는 값을 가리키지 못하게 하려고 지정

        return x;
    }

    public int peek() throws EmptyIntQueueException{
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        return que[front];
    } // peek에서는 front가 가리키는 값을 가져옴 (논리적인 첫 번째, 실제 배열에서는 가장 작은 인덱스가 아닐 수도 있음)

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x){
        for (int i = 0; i < num; i++){
            int idx = (i+front) % capacity;
            if(que[idx] == x){
                return idx;
            }
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= capacity;
    }

    public void dump(){
        if(num <= 0){
            System.out.println("큐가 비어있습니다.");
        }
        else{
            for (int i = 0; i < num; i++){
                System.out.print(que[(i+front) % capacity] + " "); // 순환하기 때문에 capacity로 나눈다.
            }
            System.out.println();
        }
    }
    
}
