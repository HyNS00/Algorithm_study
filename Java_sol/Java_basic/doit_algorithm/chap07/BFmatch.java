package doit_algorithm.chap07;
import java.util.Scanner;
public class BFmatch {
    static int bfMatch(String txt, String pat){
        int pt = 0; // 원본의 포인터
        int pp = 0; // 찾으려는 단어의 포인터

        while(pt != txt.length() && pp != pat.length()){
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt-pp+1; // 포인터를 다시 시작해서 봐야하기 때문  기준점 변화
                pp =0;
            }
        }
        if(pp == pat.length())
            return pt - pp; // 시작 포인트
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);
        if(idx == -1){
            System.out.println("텍스트에 패턴이 존재하지 않는다.");
        }
        else{
            int len = 0;
            for(int i = 0; i < idx; i++){
                len += s1.substring(i,i+1).getBytes().length;
            }
            len+= s2.length();
            System.out.println((idx+1) + "번째 문자부터 일치");
            System.out.println("텍스트:" +s1);
            System.out.printf(String.format("패턴 : %%%ds\n",len),s2);
        }
    }
}
