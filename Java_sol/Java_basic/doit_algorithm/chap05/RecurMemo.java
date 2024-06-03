// 메모화
// 동일한 계산을 반복해야 할 때, 이전에 계산한 결과를 저장하고 재사용하여 성능을 향상시키는 기술
package doit_algorithm.chap05;
import java.util.Scanner;
public class RecurMemo {
    static String[] memo;

    static void recur(int n){
        if(memo[n+1] != null){
            System.out.print(memo[n+1]);
        }
        else{
            if(n > 0){
                recur(n-1);
                System.out.println(n);
                recur(n-2);
                memo[n+1] = memo[n] + n + "\n" + memo[n-1]; // 메모화
            }else{
                memo[n+1] = "";
            }
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        memo = new String[x+2];
        recur(x);
    }
}
