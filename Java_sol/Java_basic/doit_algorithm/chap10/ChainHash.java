package doit_algorithm.chap10;

public class ChainHash<K,V> {
    // 해시를 구성하는 노드
    class Node<K,V>{
        private K key;
        private V data;
        private Node<K,V> next; // 다음 노드에 대한 참조

        Node(K key, V data, Node<K,V> next){
            this.key = key;
            this.data = data;
            this.next = next; // 다음 노드를 인자로 가짐짐
        }

        K getKey(){
            return key;
        }
        
        V getValue(){
            return data;
        }

        public int hashCode(){
            return key.hashCode();
        }
    }
    private int size; // 해시테이블 크기
    private Node<K,V>[] table; // 해시 테이블
    public ChainHash(int capacity){
        try{
            table = new Node[capacity];
            this.size = size;
        }catch(OutOfMemoryError e){
            this.size = 0;
        }
    }   
    
    // 해시값을 구하는 함수 -> 해시함수
    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    public V search(K key){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];

        while(p != null){
            if(p.getKey().equals(key)){
                return p.getValue();
            }
            p = p.next;
        }
        return null;
    }

    // 키 값이 key이고 데이터가 data인 요소를 추가
    public int add(K key, V data){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];

        while(p != null){
            if(p.getKey().equals(key)){
                return 1;
            }
            p = p.next;
        }

        Node<K,V> tmp = new Node<K,V>(key,data,table[hash]);
        // 현재 1번 노드를 next 노드로 가지는 새 노드 tmp를 생성
        table[hash] =tmp; // 1번에 add
        return 0;
    }

    // 키 값이 key인 요소를 삭제
    public int remove(K key){
        int hash = hashValue(key);
        Node<K,V> p = table[hash]; // 선택노드
        Node<K,V> pp = null; // 바로 앞의 선택 노드

        while(p != null){
            if(p.getKey().equals(key)){
                if(pp == null) // 찾으려는 노드가 바로 앞의 노드임을 알 수 있다.
                    // 첫 번째 노드를 p의 .next 노드로 설정
                    table[hash] = p.next;
                else
                    // 그게 아니라면 pp.next를 p.next로 설정해서 p를 삭제
                    // p.getKey().equals(key)에서 첫번 째 시도 만에 p를 찾은게 아니면, 즉 첫번째 노드가 아니면
                    // pp는 값을 가지고 있는다.
                    pp.next = p.next; 
                return 0;
            }
            pp = p;
            p = p.next; // 다음 노드 선택
        }
        return 1;
    }

    public void dump(){
        for(int i = 0; i < size; i++){
            Node<K,V> p = table[i];
            System.out.printf("%02d  ", i);
            while(p != null){
                System.out.printf("-> %s (%s)  ", p.getKey(),p.getValue());
                p = p.next;
            }
        }
        System.out.println();
    }
    
}
