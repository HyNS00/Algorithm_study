package doit_algorithm.chap01;
import java.util.Scanner;

public class Alternative2 {
    // Alternative 1보다 나은 상황, 상황을 짧게 쪼개서 요약
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("+와 -를 번갈아 n개 출력합니다.");
        do{
            System.out.print("n값: ");
            n = stdIn.nextInt();
        }while(n <= 0);
        
        for (int i = 0; i < n/2; i++){
            System.out.print("+-");
        }
        /*살짝 더 개선
            for(int i =1; i<= n/2; i++){
                ...
            }
         */
        // 홀수일 경우 추가 "+"출력
        
        if (n % 2 != 0){
            System.out.print("+");
        }
    }
}
