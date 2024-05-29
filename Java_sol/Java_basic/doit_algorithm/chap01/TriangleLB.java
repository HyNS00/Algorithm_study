package doit_algorithm.chap01;
import java.util.Scanner;
public class TriangleLB {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;

        do{
            System.out.println("몇 단 삼각형인가요?");
            n = stdIn.nextInt();
        }while(n <= 0);

        for(int i = 1; i <= n; i++){
            for (int j = 1; j<= i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
