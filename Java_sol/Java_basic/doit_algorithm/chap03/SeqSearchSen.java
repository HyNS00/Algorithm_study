// 보초법으로 구현한 선형검색
// Sentinel 검색에서는 배열 끝에 도달했는지 여부를 확인할 필요 없이, 검색 값이 발견될 때까지 조건 검사 없이 루프를 계속 돌 수 있다.
// SeqSearch에서는 종료조건이 2개 1. 배열이 끝에 도달했는가 2. 검색할 값과 같은 요소를 발견했는가

// 배열 끝에 key값과 같은 보초값을 둠으로써 적어도 1번 만나기 전까지는 루프가 다 돌았는지 확인할 필요가 없다.

package doit_algorithm.chap03;

import java.util.Scanner;

public class SeqSearchSen {
    static int seqSearchSen(int[] a, int n, int key){
        int i = 0;
        a[n] = key; // 보초

        while(true){
            if(a[i] == key){
                break;
            }
            i++;
        }
        return i == n ? -1 : i; // 찾으려는 값이 있다면 배열이 끝나기 전에 만났을 것. 즉 i <= n-1
    }
    
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num+1]; // 보초를 넣을 최종배열
        for(int i = 0; i < num; i++){
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = seqSearchSen(x, num, ky);
        if(idx == -1){
            System.out.println("그 값의 요소가 없습니다.");
        }
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
