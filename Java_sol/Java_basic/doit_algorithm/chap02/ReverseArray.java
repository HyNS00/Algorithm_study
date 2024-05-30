package doit_algorithm.chap02;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    // 값을 swap하는 메소드
    static void swap(int[] a, int indx1, int indx2){
        int t =a[indx1];
        a[indx1] = a[indx2];
        a[indx2] = t;
    }

    // 배열 a의 요소를 역순으로 정렬
    // 배열이 있을 시 양쪽을 번갈아가면서 바꿀것이니 전체 길이의 절반만 수행하면 된다.
    static void reverse(int[] a){
        for(int i = 0; i <a.length /2; i++){
            swap(a,i,a.length-i-1);
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] x = new int[num];

        for(int i =0; i < num; i++){
            System.out.print("x[" + i +"]: ");
            x[i] = stdIn.nextInt();
        }

        reverse(x);

        System.out.println("x = " + Arrays.toString(x));
    }
    
}
