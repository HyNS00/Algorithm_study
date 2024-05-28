import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ArrayListEx1{
    public static void main(String[] args){
        // ArrayList list1 = new ArrayList(10);
        Integer[]arr = {1,2,3,4,5,6};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}