package doit_algorithm.chap08;
import java.util.Comparator;

public class LinkedList<E>{
    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head; //머리 포인터
    private Node<E> crnt; // 선택 포인터
    public LinkedList(){
        head = crnt = null;
    }
    // 노드 검색 search
    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head; // 현재 스캔 중인 노드
        while(ptr != null){
            if(c.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data; //찾았다면 data를 반환
            }

            ptr = ptr.next;
        }
        return null; // 검색 실패 -> 값이 존재하지 않음
    }
    // 노드를 첫 번째의 삽입
    public void addFirst(E obj){
        Node<E> ptr = head;
        head = crnt=   new Node<E>(obj,ptr);
        // 첫 번째로 삽입하는 거니까 현재 head였던 ptr을 .next로 가지는 노드를 생성하고 head에 대입
    }

    // 노드를 마지막에 삽입하는 addLast
    public void addLast(E obj){
        if(head ==  null){
            addFirst(obj) // 리스트가 비어있다면 첫번째로 삽입
        }
        else{
            Node<E> ptr = head;
            while(ptr.next != null){
                ptr = ptr.next; // 마지막 노드는 ptr.next가 null이니까 마지막 노드를 찾을 때까지 
            }
            ptr.next = crnt = new Node<E>(obj,null); // 마지막 노드니까 가리키는 게 없는 null
        }
    }

    public void removeFirst(){
        if(head != null)
            head = crnt = head.next; // head를 head.next로 옮겨줌
    }
    // 꼬리 노드를 삭제
    public void removeLast() {
        if(head != null){
            if(head.next == null){
                removeFirst(); // 첫번째 노드면 머리를 제거
            }
            else{
                Node<E> ptr = head; // 현재 노드를 가리키는 노드
                Node<E> pre = head; // 현재 노드의 앞을 가리키는 노드
                // 둘 다 head에서 시작하는 이유는 노드를 순회하기 위해서 인 것 같다.
                
                while(ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                } // 반복문이 진행되면서 ptr 은 ptr.next를 가리키고, pre은 ptr을 가리키면서 한칸씩 서로 이동

                pre.next = null; // ptr.next가 null이란 말은 ptr이 마지막 노드에 도달했음을 알 수 있으므로 ,
                // pre.next를 null로 만듦으로써 ptr(마지막 노드)을 없애버리는 작업을 한다.
                crnt = pre; 
            }
        }
    }

    public void remove(Node p){
        if(head != null){
            if (p == head){
                removeFirst();
            }
            else{
                Node<E> ptr = head;

                while(ptr.next != p){
                    ptr = ptr.next;
                    if(ptr == null) return; //p가 리스트에 없을 때
                }

                ptr.next = p.next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode(){
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear(){
        while(head != null) // 노드에 아무것도 없을 때까지 머리 노드를 삭제
            removeFirst();
        crnt = null;
    }

    // 선택 노드를 하나 뒤쪽으로 진행
    public boolean next(){
        if(crnt == null || crnt.next == null){ // crnt가 null -> 리스트가 비어있음, crnt.next가 null -> 마지막 노드임으로 진행 불가
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode(){
        if(crnt == null){
            System.out.println("선택한 노드가 없습니다.");
        }
        else{
            System.out.println(crnt.data);
        }
    }

    public void dump(){
        Node<E> ptr = head;
        while(ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}