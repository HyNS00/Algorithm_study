package doit_algorithm.chap08;
import java.util.Comparator;

public class DoubleLinkedList<E> {
    // 꼬리 노드가 머리 노드를 가리키는 연결리스트 -> 원형 리스트
    // 마지막 노드 꼬리의 .next가 head를 가리킴
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        } //기본생성자 -> head노드

        Node(E obj, Node<E> prev, Node<E> next){
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList(){
        head = crnt = new Node<E>(); // 더미 노드를 생성
    }

    public boolean isEmpty(){
        return head.next == head;
    }

    // 노드를 검색하는 메서드 search
    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head.next;

        while(ptr != head){
            if(c.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null; // 검색 실패
    }
    // 선택 노드를 출력
    public void printCurrentNode(){
        if(isEmpty()){
            System.out.println("선택 노드가 없습니다.");
        }
        else{
            System.out.println(crnt.data);
        }
    }

    public void dump(){
        Node<E> ptr = head.next;
        while(ptr != head){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    } // 모든 노드 출력
    
    public void dumpReverse(){
        Node<E> ptr = head.prev;

        while(ptr != head){
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    } // 반대로 출력

    // 선택 노드를 앞쪽으로 진행
    public boolean prev(){
        if(isEmpty() || crnt.prev == head){
            return false;
        }
        crnt = crnt.prev;
        return true;
    }

    public void add(E obj){
        Node<E> node new Node<E> (obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node; // 사이에 집어 넣는 것
        // 당연한거지만 오른쪽에서 왼쪽으로 생각한다.
        // crnt.prev | crnt | crnt.next 순으로 생각
        crnt = node;
    }

    // 머리에 노드를 삽입
    public void addFirst(E obj){
        crnt = head;
        add(obj);
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj){
        crnt = head.prev; // 원형이기에 꼬리의 전 노드는 head다
        add(obj);
    }

    // 선택 노드를 삭제
    public void removeCurrentNode(){
        if(!isEmpty()){
            crnt.prev.next=  crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if(crnt == head){
                crnt = head.next;
            }
        }// crnt.prev | crnt | crnt.next 순으로 존재하니까
        // crnt가 사라지고 crnt.prev의 다음 노드는 crnt.next가 된다 -> crnt.prev.next = crnt.next
        // crnt가 사라지니 crnt.next의 전 노드는 crnt.prev가 된다 -> crnt.next.prev = crnt.prev;
    }

    // 노드를 삭제
    public void remove(Node p){
        Node<E>  ptr = head.next;
        while(ptr != head){
            if(ptr == p){
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr= ptr.next;
        }
    }

    // 머리 노드를 삭제
    public void removeFirst(){
        crnt = head.next; // 첫 번째 노드 말고 더미노드인 head가 존재
        // 단순히 head.next를 변경해줌으로써옮겨준다.
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제
    public void removeLast(){
        crnt = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제
    public void clear(){
        while(!isEmpty()){
            removeFirst();
        }
    }
}
