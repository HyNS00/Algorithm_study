package doit_algorithm.chap06;
import java.util.Scanner;
public class MergeSort {
    static int[] buff; // 작업용 배열

    static void __mergeSort(int[] a, int left, int right){
        // 생각은 2개로 나눠서 하지만 실제 구현은 a와 buff 2개
        // buff와 a의 있는 내용을 비교해서 대입
        if(left < right){
            int i;
            int center = (left+right)/2;
            int p = 0;
            int j = 0;
            int k =left;
            
            __mergeSort(a, left, center);
            __mergeSort(a,center+1,right);

            for(i = left; i <= center; i++){
                buff[p++] = a[i];
            }

            while(i <= right && j < p){
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }
            while(j<p){
                a[k++] = buff[j++];
            }
        }
    }

    static void mergeSort(int[] a, int n){
        buff = new int[n];
        __mergeSort(a, 0, n-1);
        buff = null; // 작업용 배열 해체
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.print("요솟수 :");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        mergeSort(x, nx);
        System.out.println("오름 차순 정렬");
        for(int i = 0; i < nx; i++){
            System.out.println("x[" + i +"]= " + x[i]);
        }
    }
}
