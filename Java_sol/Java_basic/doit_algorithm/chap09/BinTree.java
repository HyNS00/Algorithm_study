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
    private void addNode(Node<K,V> node, K key, V data){
        int cond = comp(key,node.getKey());
        // 값을 비교
        if(cond == 0){
            return; // 값이 같을시 추가할 수 없으므로 종료
        }
        else if(cond < 0){
            if(node.left == null){
                node.left = new Node<K,V>(key, data, null, null);
            }
            else
                addNode(node.left, key,data); // 왼쪽서브트리에서 시작
        }else{
            if(node.right == null)
                node.right = new Node<K,V>(key, data, null,null); //오르쪽이 비어있을 경우 자식 노드가 없는 노드를 추가
            else 
                addNode(node.right, key, data); //오른쪽 서브트리에서 시작    
        }   
    }

    public void add(K key, V data){
        if(root == null){
            root = new Node<K,V>(key, data,null,null); //트리가 비어있는 경우, 자식노드가없는 새 루트 노드를 생성
        }
        else{
            addNode(root,key,data);
        }
    }
    // 삭제는 세 가지 경우로 나뉜다.
    /*
        1. 자식 노드가 없는 노드를 삭제하는 경우 -> 삭제할 노드를 찾은 뒤, 왼쪽(오른쪽)자식이라면 부모의 왼쪽(오른쪽) 자식 포인터를
             null로 만든다.
        2. 자식 노드가 1개인 노드를 삭제하는 경우 -> 삭제할 노드를 찾은 뒤, 왼쪽(오른쪽) 자식이라면 부모의 왼쪽(오른쪽) 포인터가
            삭제 대상 노드의 자식을 가리키도록 한다.
        3.  자식 노드가 2개인 개인 노드를 삭제하는 경우 (중요) -> 
            a.삭제할 노드의 왼쪽 서브트리에서 키 값이 가장 큰 노드를 찾는다.
            b. 검색한 노드의 데이터를 삭제 대상 노드로 복사한다.
            c. 검색한 노드를 삭제(왼쪽 서브트리에서 키 값이 가장 큰 노드) -> 자식이 없다면 1번, 자식이 1개만 있을 경우 2번 
            
     */
    public boolean remove(K key){
        Node<K,V> p = root;
        Node<K,V> parent = null;
        boolean isLeftChild = true;

        while(true){
            if(p == null) // p를 찾는 중, key의 크기에 따라 왼쪽 오른쪽 서브트리
                return false;
            int cond = comp(key,p.getKey());
            if(cond == 0){
                break;
            }
            else{
                parent = p;
                if(cond < 0){
                    isLeftChild = true;
                    p =p.left;
                }else{
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }
        if(p.left == null){ //p에 왼쪽 자식이 없음
            if(p == root){
                root = p.right;
            }
            else if(isLeftChild){
                parent.left = p.right; // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킨다.
            }
            else{
                parent.right  = p.right; // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
            }
        }else if(p.right == null){ // p에 오른쪽 자식이 없다.
            if(p == root){
                root = p.left;
            }
            else if(isLeftChild){
                parent.left = p.left; // 부모의 왼쪽포인터가 왼쪽 자식을 가리킨다.
            }
            else{
                parent.right = p.left; // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
            }
        }
        else{
            parent =p; 
            Node<K,V> left = p.left; // p의 왼쪽 서브트리
            isLeftChild = true;
            // 왼쪽 서브트리에서 가장 큰 노드를 찾음
            // 계속해서 오른쪽으로 이동
            while(left.right != null){
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key; // left의 키 값을 p로 옮김
            p.data = left.data; // data를 옮김
            if(isLeftChild)
                parent.left =left.left; //
            else    
                parent.right = left.left; //left를 삭제
        }
        return true;
    }
    private void printSubTree(Node node){
        if(node != null){
            printSubTree(node.left); // 왼쪽 서브트리 출력
            System.out.println(node.key+ " " + node.data);
            printSubTree(node.right); // 오른쪽 서브트리
        }
    }
    public void print(){
        printSubTree(root);
    }
}
