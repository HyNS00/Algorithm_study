package doit_algorithm.chap06;

public class ShellSort {
    // 셸 정렬
    // 단순 삽입정렬의 장점은 살리고 단점은 보안 -> 정렬 해야하는 횟수는 늘지만, 요소의 이동 횟수가 줄어듬
    // 배열을 n개의 그룹으로 나누고, 그룹 내에서 정렬 -> 그룹 수를 줄여가면서 반복
    
    static void shellShort(int [] a, int n){
        // h : 증분값 
        for(int h = n/2; h >0; h/=2){
            for(int i = h; i < n; i++){
                int j;
                int tmp = a[i];
                for(j = i-h; j >= 0 && a[j] > tmp; j-=h){
                    a[j+h] = a[j];

                }
                a[j+h] = tmp;
            }
        }
    }
}
