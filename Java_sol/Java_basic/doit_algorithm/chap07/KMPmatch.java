package doit_algorithm.chap07;

public class KMPmatch {
    static int kmpMatch(String txt, String pat){
        // 실패함수표 만들기
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pat.length()+1];


        skip[pt] = 0;
        while(pt != pat.length()){
            if(pat.charAt(pt) == pat.charAt(pp)){
                skip[++pt] = ++pp;
            }
            else if(pp == 0){
                skip[++pt] =pp;
            }
            else
                pp = skip[pp];
        }
        // 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }

        if (pp == pat.length())        // 패턴의 모든 문자를 대조
            return pt - pp;
        return -1;
    }
}
