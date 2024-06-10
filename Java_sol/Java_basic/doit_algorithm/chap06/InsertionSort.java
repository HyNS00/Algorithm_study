package doit_algorithm.chap06;
import java.util.Scanner;

public class InsertionSort {
    // 단순 삽입 정렬
    // 정렬되지 않은 부분의 첫 번째 요소를 정렬된 부분의 '알맞은 위치에 삽입'하는 작업을 n-1번 반복

    // j값을 감소시키면서 큰 값이 나왔을 경우 , 그 값과 값을 바꿈 -> 삽입
    static void insertionSort(int[] a, int n){
        for(int i = 1; i < n; i++){
            int j;
            int tmp = a[i];
            for(j = i; j > 0 && a[j-1] > tmp; j--){
                a[j] = a[j-1];
            }
            a[j] = tmp;
            
        }
    }
}
