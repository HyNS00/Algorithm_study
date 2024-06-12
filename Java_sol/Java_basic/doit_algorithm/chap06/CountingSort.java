package doit_algorithm.chap06;

public class CountingSort {
    static void countingSort(int[] a, int n, int max){
        int[] f = new int[max+1];
        int[] b = new int[n];

        for(int i = 0; i < n; i++){
            f[a[i]]++; // 도수 분포표 만들기 -> 카운트 배열
        }
        for(int i = 1; i <= max; i++){
            f[i] += f[i-1];
        } // 누적 분포표 

        for(int i = n-1; i >= 0; i--){
            b[--f[a[i]]] = a[i];
        } // 알맞은 자리에 들어갈 수 있게 함

        for(int i = 0; i < n; i++){
            a[i] = b[i];
        }
    }    
}
