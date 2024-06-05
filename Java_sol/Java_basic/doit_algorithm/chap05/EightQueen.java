package doit_algorithm.chap05;

public class EightQueen {
    // QueenBB에서 같은 행에 설치하지 않는 것을 토대로
    // 양쪽 대각선에도 똑같이 넣는 것을 한다.
    // 좌측 대각선 우측 대각선을 나눠 flag를 가지고 비교
    // 좌측 대각선의 경우 -> (열 - 행) + 전체 행을 할 경우 같다
    // 우측 대각선의 경우 -> (열+ 행)값이 같다.

    // 이 정보들을 가지고 코드를 짜보자 
    static int[] pos = new int[8];
    static boolean[] flag = new boolean[8];
    static boolean[] flag_r = new boolean[15];  // 우 대각선
    static boolean[] flag_l = new boolean[15]; // 좌 대각선

    static void print(){
        for(int i = 0; i < 8; i++){
            System.out.printf("%2d",pos[i]);
        }
        System.out.println();
    }

    static void set(int i){
        for (int j = 0; j < 8; j++){
            if(flag[j] == false && flag_r[i-j+7] == false && flag_l[i+j] == false){
                pos[i] = j;
                if(i == 7){
                    print();
                }
                else{
                    flag[j] = flag_l[i+j] = flag_r[i-j+7] = true;
                    set(i+1);
                    flag[j] = flag_l[i+j] = flag_r[i-j+7] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        set(0);
    }
}
