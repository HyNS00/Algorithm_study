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
   
}
