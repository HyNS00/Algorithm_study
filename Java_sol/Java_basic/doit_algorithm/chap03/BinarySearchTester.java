// binarySearch  -> 오름차순으로 정렬된 배열 a를 가정하고, 값이 key인 요소를 이진검색
// 자료형과 관계없이 사용할 수 있도록 9가지 오버로딩
// 검색에 성공한 경우 - 요소의 인덱스를 반환하지만, 같은 요소가 여러 개 있을 경우엔 어느 것의 위치를 반환하는지 모름
// 검색에 실패한 경우 - 배열 안에 key가 있어야할 위치를 추정할 수 있는 값을 반환.  반환값 -x-1
// 예를 들어 4 와 5 사이에 있어야할 것 같다면 삽입포인트는 5이므로 -(5)-1로 인해 반환값 -6

package doit_algorithm.chap03;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearchTester {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for(int i = 1; i < num; i++){
            do{
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            }while(x[i] < x[i-1]);
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, ky);
        // 배열 x에서 ky 요소를 검색
        if(idx < 0){
            System.out.println("그 값의 요소는 없습니다.");
        }
        else{
            System.out.print("그 값은 x[" + idx +"]에 있습니다.");
        }
    }
}
