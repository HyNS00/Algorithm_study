package doit_algorithm.chap03;
import java.util.Scanner;
public class BinSearchX {
    static int binSearchX(int[] a, int n, int key){
        int head = 0;
        int tail = n-1;
        int result = -1; // 초기값
        while(head <= tail){
            int mid = (head+tail)/2;
            if(a[mid] == key){
                result = mid; // 반환값 저장
                tail = mid -1;  // 앞쪽에 key값이 있는지 확인
            }
            if(a[mid] > key){
                tail = mid -1; // 앞쪽으로 당김
            }

            if(a[mid] < key){
                head = mid +1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num];	

        System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0] : ");
		x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			} while (x[i] < x[i - 1]);	// 바로 앞의 요소보다 작으면 다시 입력 받음
		}

		System.out.print("검색 값 : ");			// 키값을 입력받음
		int ky = stdIn.nextInt();

		int idx = binSearchX(x, num, ky);	// 배열 x에서 값이 ky인 요소를 검색

		if (idx == -1)
			System.out.println("그 값의 요소는 존재하지 않습니다.");
		else
			System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
