package doit_algorithm.chap06;

public class HeapSort {
    /*
     * 힙 -> '부모값 >= 자식'을 항상 만족하는 완전 이진 트리
     * 따라서 루트 노드 값이 가장 크다, 단 자식의 대소가 왼쪽 오른쪽은 차이가 없다. 아무거나 가능
     * 힙정렬은 이러한 힙의 특징을 이용한 정렬 알고리즘
     * 가장 큰 값은 루트 노드와 맨 마지막 노드의 값을 바꾸고 힙상태로 만들고 다시 루트 노드를 내리는 것을 반복한다.
     */

    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    } 

    // downHeap 메소드는 루트 노드와 위치를 바꾼 다음 힙상태가 아닌 것을 힙상태로 바꿔주는 메소드
    // 맞바꾼 노드를 알맞은 위치로 옮겨주면서 힙 상태를 유지하게 함
    // 위에서 아래로부터 옮겨감, a[left]를 제외한 나머지는 힙 상태라고 가정하고 시작
    static void downHeap(int[] a, int left, int right){
        int temp = a[left];
        int child;
        int parent;
        // for문의 마지막은 
        for(parent = left; parent < (right+1)/2; parent = child){ 
            // 길이가 n일 때, 부모의 인덱스는 최대 n/2 -1 그 뒤로는 자식이 없다.
            // 부모의 인덱스 [(i-1)/2]
            // 왼쪽 자식 [i*2 +1]
            // 오른쪽 자식[i*2 +2] = 왼쪽 자식 +1
            // parent = child를 통해 업데이트 -> 증감 연산자가 아니라 이렇게 표현
            // 반복문을 시행할 때마다 변화하는 값으로 표현 
            int cl = parent * 2 +1;
            int cr = cl +1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if(temp >= a[child])
                break;
            a[parent] = a[child];

        }
        a[parent] = temp;
    }
    // 힙 정렬
    static void heapSort(int[] a, int n){
        for(int i = (n-1)/2; i >= 0; i--){ // (n-1) -2는 자식을 가진 마지막 부모 노드의 인덱스
            downHeap(a, i, n-1);
        }

        for(int i = n-1; i > 0; i--){
            swap(a,0,i);
            downHeap(a,0,i-1);
        }
    }

    // 시간복잡도  -> 단순 선택정렬 O(n)
    // 다시 힙으로 만드는 과정 -> O(log n)
    // 전체 시간 복잡도 O(n log n)
}
