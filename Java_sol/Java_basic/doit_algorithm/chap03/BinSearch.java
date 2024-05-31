// 이진 검색은 요소가 오름차순 또는 내림차순으로 정렬된 배열에서 검색하는 알고리즘이다.
// 검색범위를 정할 때, 맨 앞은 pl (0), 맨 뒤는 pr(n-1) , pc (n-1/2)로 한다.
// 검색을 진행할 때마다 key보다 작거나(큰) 값들은 검색 대상에서 제외를 한다.

package doit_algorithm.chap03;
import java.util.Scanner;
public class BinSearch {
    static int binSearch(int[] a, int n, int key){
        int pl = 0;
        int pr = n-1;
        do{
            int pc = (pl+pr) /2;
            if(a[pc] == key){
                return pc; 
            }
            else if (a[pc] < key){ 
                pl = pc +1; // 검색 범위를 뒤쪽으로
            }
            else 
                pr = pc -1; // 검색 범위를 앞쪽으로
        }while(pl <= pr);


        return -1; // 검색을 실패했을 경우
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요");
        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for(int i = 1; i < num; i++){
            do{
                System.out.print("x[" + i +"]: ");
                x[i] = stdIn.nextInt();
            }while(x[i] < x[i-1]); // 입력받은 값이 전의 것보다 작다면 다시 실행
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x,num,ky);
        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }
        else{
            System.out.println("그 값은 x[" + idx +"]에 있습니다.");
        }
    }
}
