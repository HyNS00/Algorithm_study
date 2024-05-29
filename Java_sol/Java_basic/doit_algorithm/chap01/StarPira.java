package doit_algorithm.chap01;
import java.util.Scanner;
public class StarPira {
    // n단의 피라미드를 출력
    static void spira(int n){
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= n-i; j++){
                System.out.print(' ');
            }
            for(int j=1; j <= (i-1)*2 + 1; j++){
                System.out.print('*');
            }

            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;
        do{
            n = stdIn.nextInt();
        }while(n <= 0);
        spira(n);
    }
    
}
