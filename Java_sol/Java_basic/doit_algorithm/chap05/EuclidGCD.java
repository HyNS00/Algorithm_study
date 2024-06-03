// 유클리드 호제법
// 두 개의 자연수 a,b에 대하여  a를 b로 나눈 나머지를 r이라고 할 때 a와 b의 최대 공약수는 b와r의 최대공약수와 같다.
// 연습 문제 -> 배열에서 사용하려면 순서대로 인덱스 순서대로 메서드를 넣으면 된다.
package doit_algorithm.chap05;
import java.util.Scanner;
public class EuclidGCD {
    static int gcd(int x,int y){
        if(y == 0){
            return x;
        }
        else 
            return gcd(y, x % y);
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대 공약수를 구합니다.");
        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        System.out.print("정수를 입력하세요: ");
        int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd(x,y));
    }
    
}
