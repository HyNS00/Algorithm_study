package doit_algorithm.chap06;

public class QuickSort3 {
    // 퀵정렬에서 피벗의 선정
    // 1. 요솟수가 3개이상이면 임의의 요솟수 3개를 선택하고, 그 중에서 중앙값을 피벗으로 선택
    // 2. 맨 처음, 맨 끝 , 중간을 선택해 정렬( 1번에서 발전)
    /*
     * 가운데 요소와 끝에서 두 번 째 요소를 교환 -> 두 번째 요소를 피벗으로 함
     * 범위를 left+1 ~ right-2로 좁혀서 퀵정렬 시작
     * right -1은 피벗이상, left은 피벗 이하로 시작
     * 
     * pl은 오른쪽으로 한칸 이동, pr은 왼쪽으로 두칸 이동 -> quickSort 하기 전 시행
     */
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] =t;
    }
    
    // (처음 끝 가운데)의 요소를 정렬하고 중간을 반환
    static int sort3elem(int[] x, int a, int b,int c){
        if(x[b] < x[a]) swap(x,b,a);
        if(x[c] < x[b]) swap(x,c,b);
        if(x[b] < x[a]) swap(x,b,a);
        return b;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int m = sort3elem(a,pl,(pl+pr)/2, pr);
        int x = a[m];

        swap(a,m,right-1); // 가운데요소와 끝에서 두 번째 요소를 교환
        pl++;
        pr -=2; // 선작업

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;

            if(pl <= pr)
                swap(a,pl++,pr--);
        }while(pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);

    }
}
