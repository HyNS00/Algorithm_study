package doit_algorithm.chap05;

public class QueenBB {
    // QueenB가 열에 배치하는 방법을 표시했다면,    
    // 각 행에 1개만 배치 하는 코드
    static boolean[] flag = new boolean[8]; // 같은 행에 존재하는지 여부 판단
    static int[] pos = new int[8];

    static void print(){
        for(int i =0; i <8; i++){
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }
    static void set(int i){
        for(int j = 0; j < 8; j++){
            if(flag[j] == false){ // j행에 배치하지 않았을 경우
                pos[i] = j;
                if(i == 7){
                    print();
                }
                else{
                    flag[j] = true;
                    set(i+1);
                    flag[j] = false; // 다시 돌아가서 백트래킹 
                }

            }
        }
    }

    public static void main(String[] args){
        set(0);
    }

}
