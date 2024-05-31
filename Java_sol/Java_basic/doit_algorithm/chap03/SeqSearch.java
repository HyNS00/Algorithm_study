package doit_algorithm.chap03;
import java.util.Scanner;
public class SeqSearch {
    // 선형검색
    // 요솟수가 n인 배열 a에서 key와 같이 같은 요소를 선형검색
    // 무작위로 배열되어있어도 무관하다.
    static int seqSearch(int[] a, int n, int key){
        int i = 0;
        while(true){
            if(i == n){
                return -1;
            }
            if(a[i] == key){
                return i;
            }
            i++;
        }
        // while문으로 표현하지 않고 다음과 같이 표현할 수도 있다.
        /*
         for(int i = 0; i < n; i++){
            if(a[i] == key){
                return i;
            }
         }
         return -1;
         */
    }
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < x.length; i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky);
        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
    
}
