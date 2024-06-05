package doit_algorithm.chap05;

public class QueenB {
    // 각 열에 퀸을 1개씩만 배치하는 코드
    static int[] pos = new int[8];

    static void print(){
        for(int i = 0; i < 8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    // i열에 퀸을 배치
    static void set(int i){
        for(int j = 0; j < 8; j++){
            pos[i] = j; // i열에 놓인 위치가 j행 -> (j,i)
            // 좋은 아이디어 
            if(i == 7){
                print();
            }

            else
                set(i+1);
        }
    }

    public static void main(String[] args){
        set(0);
    }
}
