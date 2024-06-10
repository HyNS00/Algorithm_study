package doit_algorithm.chap06;

public class ShellSort2 {
    // 셸 정렬의 다른 형태
    // 수열로 시작
    static void shellSort(int[] a, int n){
        int h;
        for(h = 1; h <n; h = h * 3+1){
            ; // h값을 설정하는 역할만 수행
        }

        for(; h > 0; h/= 3){
            for(int i = h; i < n; i++){
                int j;
                int tmp = a[i];
                for(j = i-h; j>=0 && a[j] > tmp; j-=h){
                    a[j+h] = a[j];
                }
                a[j+h] = tmp;
            }
        }
    }
}
