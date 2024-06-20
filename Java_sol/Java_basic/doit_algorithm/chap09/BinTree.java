package doit_algorithm.chap09;
import java.util.Comparator;
// import java.util.Comparable; <- java.lang에 존재
public class BinTree<K,V> {
    static class Node<K,V>{
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        Node(K key, V data, Node<K,V> left, Node<K,V> right){
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }
        void print(){
            System.out.println(data);
        }
    }
    private Node<K,V> root;
    private Comparator<? super K> comparator = null; // 비교자
    // comparator는 Comparator를 구현한 클래스
    public BinTree(){
        root = null;
    }

    public BinTree(Comparator<? super K>c){ // <? super K> K와 K의 상위 클래스
        // <? extends K> K와 K의 하위 클래스
        this(); //기본 생성자 호출
        comparator = c;
    }

    private int comp (K key1, K key2){
        return (comparator == null) ? (((Comparable<K>)key1).compareTo(key2)) : comparator.compare(key1,key2);
    }
    // Comparable<K> : Comparable은 java.lang에 있으므로 import할 필요 x
    // ((Comparable<K>)key1) : key1이 자료형이 K인 Comparable을 구현한 클래스
    // 따로 comparator를 인자로 넣고 생성자를 호출한게 아니라면 K의 compareTo를, 넣었다면 그 인자의 compare를 구현


    public V search(K key){ // 루트 노드를 기준으로 작으면 왼쪽, 크면 오른쪽에 있는걸 이용
        Node<K,V> p = root; // root부터 시작
        while(true){
            if(p == null){
                return null; // 검색실패
            }
            int cond = comp(key, p.getKey()); // key와 노드 p의 키 값을 비교
            if(cond == 0){ // 같을 시
                return p.getValue(); 
            }
            else if(cond < 0){ // key가 작으면 왼쪽 서브트리로 이동
                p = p.left;
            }
            else{
                p = p.right; // key가 크면 오른쪽 서브트리로 이동
            }
        }
    } 

    // 노드에 새로운 데이터를 삽입 -> 이진트리의 조건을 항상 유지해야한다.
    // 알맞은 자리를 찾아가야하고 이미 같은 값이 있다면 추가할 수 없다.
    
}
