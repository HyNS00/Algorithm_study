package doit_algorithm.chap06;
import java.util.Scanner;
public class Partition {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열을 분할 하는 법
    static void partition(int[] a, int n){
        int pl = 0;
        int pr = n-1;
        int x = a[n/2];

        do{
            while(a[pl] < x){
                pl++;
            }
            while(a[pr] > x){
                pr--;
            }
            if(pl <= pr){
                swap(a,pl++,pr--);
            }
        }while(pl <= pr);

    }
}
