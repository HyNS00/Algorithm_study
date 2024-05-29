package doit_algorithm.chap01;
import java.util.Scanner;

public class Multi99Table {
    public static void main(String[] args){
        // 구구단
        for(int i =1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.printf("%3d",i*j);
            }
            System.out.println();
        }
    }
}
