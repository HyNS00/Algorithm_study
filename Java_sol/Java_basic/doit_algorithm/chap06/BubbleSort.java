// 버블정렬 ->이웃한 두 요소의 대소 관계를 비교하고 필요에 따라 교환을 반복
// 패스(비교 + 교환) -> n 길이의 배열에서  n-1번 반복

package doit_algorithm.chap06;
import java.util.Scanner;
public class BubbleSort{
    
    //  교환
    static void swap(int[] a , int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬
    static void bubbleSort(int[] a, int n){
        for(int i =0; i < n-1; i++){ // 패스 과정은 n-1번
            for(int j = n-1; j > i; j--){ // j > i인 이유는 앞에 이미 앞쪽의 i개의 원소는 정렬이 된 것이므로 제외한다.
                if(a[j-1] > a[j])
                    swap(a,j-1, j);
            }
        }
    }

    // 버블 정렬 앞에서
    static void bubbleSortEx(int [] a, int n){
        for(int i = n-1; i > 0; i++){
            for (int j = 0; j < i; j++){
                if(a[j] > a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }
    }

    static void bubbleSort2(int[] a, int n){
        for(int i =0; i < n-1; i++){
            int exchg = 0;
            for (int j = n-1; j > i; j--){
                swap(a,j-1,j);
                exchg++;
            }
            if (exchg == 0){
                break;
            }
        }
    } // exchg 라는 변수를 통해 교환이 이뤄졌는지 확인한다. -> 이뤄지지 않았다면 정렬을 멈춘다
    // why? 이미 정렬되어있음을 알 수 있기 때문

    static void bubbleSort3(int[] a, int n){
        int k =0; // 모든 요소를 검색하기 위해서 0으로 초기화
        // int last = n-1; 
        while(k < n-1){ 
            int last = n-1; // 초기화함으로써, 무한루프 방지 -> 탈출조건
            for(int j = n-1; j > k; j--){
                if(a[j-1] > a[j]){
                    swap(a,j-1,j);
                    last = j; // last를 업데이트 함으로써, 다음 순환에서는 확인할 요소의 갯수를 줄인다.
                }
            }
            k = last;
        }
    }
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요솟수 :");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.print("x[" + i + "]");
            x[i] = stdIn.nextInt();
        }

        bubbleSort3(x, nx);

        System.out.println("오름 차순으로 정렬");
        for (int i = 0; i < nx; i++){
            System.out.println("x[" + i + "] = "+ x[i]);
        }
    }
}