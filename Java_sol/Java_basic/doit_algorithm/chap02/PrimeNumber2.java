package doit_algorithm.chap02;

public class PrimeNumber2 {
    // 소수는 1과 자기자신 외에 나눠지지 않는다.
    // 그렇다면 n인 소수는 1 ~ n-1까지의 존재하는 어떤 소수로도 나눠지지 않는다.
    // 소수가 존재한다면 짝수보다는 홀수로 존재할 것이다. (2 제외)
    public static void main(String[] args){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2; // 2가 가장 작은 소수, 초기값
        for(int n = 3; n <= 1000; n += 2){ // 3부터 홀수들만 넣어보기
            int i;
            for(i =1; i < ptr; i++){ // 이미 구한 소수들을 기준으로 나눠보기
                counter++;
                if(n % prime[i] == 0){ // 나눠진다면 소수가 아니다
                    break;
                }
            }
            if (ptr == i) // 끝까지 넣었을 때까지 안 나눠진다면 소수
                prime[ptr++] = n; // 넣음과 동시에 ptr 증가
        }

        for (int i = 0; i < ptr; i++){
            System.out.println(prime[i]);
        }
        System.out.println("나눗셈을 진행한 횟수: " + counter);
    }
}
