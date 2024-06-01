// 연습 문제 3번
// 요솟수가 n인 배열a에서 key와 일치하는 모든 요소의 인덱스를 배열 idx의 맨 앞부터 순서대로 저장하고,
// 일치하는 요솟수를 반환
package doit_algorithm.chap03;
import java.util.Scanner;
public class SearchIndx {
    static int searchIndex(int [] a, int n, int key, int[] idx){
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == key){
                idx[counter++] = i;
            }
        }
        return counter;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt(); // 배열의 요솟수 n을 입력받기

        int[] original = new int[num];
        int[] result = new int[num];

        for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			original[i] = stdIn.nextInt();
		}

        System.out.print("검색 값 : "); 
        int ky = stdIn.nextInt();

        int count = searchIndex(original, num, ky, result);
        if(count == 0){
            System.out.println("값이 존재하지 않습니다.");
        }
        else{
            for(int j = 0; j < count; j++){
                System.out.println("값은 " + result[j] +"입니다.");
            }
        }
    }
}
