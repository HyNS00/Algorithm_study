package doit_algorithm.chap01;
import java.util.Scanner;
public class SumWhile {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구하여라");
        System.out.print("n값 : ");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;

        while(i <= n){
            sum += i;
            i++;
        }

        System.out.println("1부터 n까지의 합은 " + sum +"입니다.");
    }
    
}
