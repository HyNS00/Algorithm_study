/*
        충돌이 발생했을 때 재해시(rehashing)를 수행하여 비어 있는 버킷을 찾아내는 방법 -> 닫힌 해시법이라고도 한다.
        요소 삽입할 때 : 빈 버킷을 만날 때까지 재해시를 여러 번 반복한다 (선형 탐사법)
        요소 삭제 : 2가지의  상태를 부여한다. 1. 비어있음 2. 삭제를 마침
        나누는 이유 : 버킷을 삭제하고 아무 표시 안할 경우 재해시하는 중복값을 찾을 때 '비어있음'으로 판단하고 검색에 실패함
        그러나 '삭제를 마침'으로 할 경우 , 재 해시를 수행한 값이 존재할 수도 있게 되는 것으로 재해시를 수행해서 값을 찾는 시도를 함
*/
package doit_algorithm.chap10;

public class OpenHash<K,V> {
    enum Status {OCUPIED, EMPTY, DELETED}; // 상태 열거형 (데이터 저장, 비어있음, 삭제 마침)

    // 버킷
    static class Bucket<K,V>{
        private K key;
        private V data;
        private Status stat;

        Bucket(){ // 생성자
            stat = Status.EMPTY;
        }

        // 모든 필드에 값을 설정
        void set(K key, V data, Status stat){
            this.key = key;
            this.data = data;
            this.stat = stat;
        }
        // 상태를 설정
        void setStat(Status stat){
            this.stat = stat;
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
    private int size;
    private Bucket<K,V>[] table;

    // 생성자
    public OpenHash(int size){
        try{
            table = new Bucket[size];
            for(int i = 0; i < size; i++){
                table[i] = new Bucket<K,V>();
            }
            this.size = size;
        }catch(OutOfMemoryError e){
            this.size = 0;
        }
    }

    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    // 재해시값을 구함
    public int rehashValue(int hash){
        return (hash + 1) % size;
    }

    // 키값이 key인 버킷을 검색
    private Bucket<K,V> searchNode(K key){
        int hash = hashValue(key); // 검색할 데이터의 해시값
        Bucket<K,V> p = table[hash]; // 선택한 버킷

        for(int i = 0; p.stat != Status.EMPTY && i < size; i++){
            if(p.stat == Status.OCUPIED && p.getKey().equals(key)) // 값을 재해시하면서 찾아봄
                return p;
            hash = rehashValue(hash); // 재해시
            p = table[hash];
        }
        return null;
    }
    
    public V search(K key){
        Bucket<K,V> p = searchNode(key);
        if(p != null){
            return p.getValue();
        }
        else
            return null;
    }

    // 키값이 key이고 데이터가 data인 요소를 추가
    public int add(K key, V data){
        if(search(key) != null){
            return 1;  // 키 값이 등록
        }
        int hash = hashValue(key);
        Bucket<K,V> p = table[hash]; // 선택한 버킷
        for(int i = 0; i < size; i++){
            if(p.stat == Status.EMPTY || p.stat == Status.DELETED){
                p.set(key,data,Status.OCUPIED);
                return 0;
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return 2; // 해시테이블이 가득참

    }

    // 키값이 key인 요소를 삭제
    public int remove(K key){
        Bucket<K,V> p = searchNode(key);
        if(p == null){
            return 1;
        }
        p.setStat(Status.DELETED);
        return 0;
    }

    // 해시 테이블 덤프
    public void dump(){
        for(int i= 0; i < size; i++){
            System.out.printf("%02d ", i);
            switch(table[i].stat){
                case OCUPIED:
                    System.out.printf("%s (%s)\n",
                                        table[i].getKey(),table[i].getValue());
                                        break;
                case EMPTY:
                    System.out.println("---비어있음---"); break;
                case DELETED:
                    System.out.println("---삭제마침---"); break;
            }
        }
    }

    
    
}
