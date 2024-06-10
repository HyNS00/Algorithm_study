package doit_algorithm.chap06;

public class SelectionSort {
    static void swap(int[] a, int idx1 ,int idx2){
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }


    static void selectionSort(int[] a, int n){
        // 선택 정렬 -> 배열에서 가장 작은 것을 찾아 그것을 배열 맨 앞으로 옮긴다.
        // 남은 배열 중 또 가장 작은 것을 맨 앞으로 옮긴다.
        // 정렬이 될 때까지 반복

        for(int i = 0; i < n-1; i++){
            int min = i;
            for (int j = i+1; j < n; j++){
                if(a[j] < a[min]){
                    min = j;
                }
            }
            swap(a,i,min);
        }
    }
}
