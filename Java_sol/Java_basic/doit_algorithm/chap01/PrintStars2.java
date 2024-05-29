package doit_algorithm.chap01;
import java.util.Scanner;

public class PrintStars2 {
    // PrintStars1의 개선 버전
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n,w;
        do{
            System.out.print("n값: ");
            n = stdIn.nextInt();
        }while(n <= 0);

        do{
            System.out.print("w값: ");
            w = stdIn.nextInt();
        }while(w <= 0 || w >n);

        for(int i = 0; i < n/w; i++){
            System.out.println("*".repeat(w)); 
            //  몫만큼 반복해서 출력
        }
        // 위의 경우는 딱 나눠 떨어질 때의 경우를 생각
        int rest = n % w;
        // 나눠 떨어지지 않았을 경우, 나머지만큼 출력
        if(rest != 0){
            System.out.println("*".repeat(rest));

        }
        
    }
}
