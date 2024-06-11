package doit_algorithm.chap06;

import doit_algorithm.chap04.IntStack;

public class QuickSort2 {
    // 비재귀적 방법으로 퀵 정렬 구현
    // 스택으로 구현
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
    static void quickSort(int[] a, int left, int right){
        IntStack lstack = new IntStack(right - left + 1); // 나눌 범위의 왼쪽 요소의 인덱스를 저장
        IntStack rstack = new IntStack(right - left +1); //  나눌 범위의 오른쪽 요소의 인덱스를 저장
        lstack.push(left);
        rstack.push(right);
        while(lstack.isEmpty() != true){
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) /2];

            do{
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;

                if(pl <= pr)
                    swap(a,pl++,pr--);
            }while(pl <= pr);

            if(left < pr){
                lstack.push(left);
                rstack.push(pr);
            } 

            if(pl < right){
                lstack.push(pl);
                rstack.push(right);
            }
            // lstack {0,4} -> 나눔
            // rstack {5,8} -> 나눔
        }
    }
    
}
