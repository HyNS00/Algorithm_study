package doit_algorithm.chap06;
// 정렬을 마친 배열을 병합하는 과정
public class MergeArray {
    static void merge(int[] a, int na, int[] b, int nb, int[] c){
        int pa = 0;
        int pb = 0;
        int pc = 0;
        // 정렬된 pa,pb를 pc로 병합
        while(pa < na && pb < nb){
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
            // 작은 쪽을 c에 저장하는데, 들어가지 않은 쪽의 인덱스는 늘어나지 않는다.
        }

        while(pa < na){
            c[pc++] =a[pa++];
        }
        while(pb < nb){
            c[pc++] = b[pb++];
        }
        // 각 a,b에 남아있는 요소를 복사
    }
    // 시간 복잡도 O(n)

}
