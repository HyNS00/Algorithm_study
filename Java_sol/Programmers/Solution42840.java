package Programmers;

import java.util.*;
import java.util.stream.*;

public class Solution42840 {
    public static void main(String[] args) {
        
    }
    public int[] solution(int[] answers){
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        // 위의 내용들이 반복
        // answers[1,2,3,4,5]
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < answers.length; i++){
            if(first[i % first.length] == answers[i]){
                map.put(1, map.getOrDefault(1,0)+1);
            }
            if(second[i % second.length] == answers[i]){
                map.put(2, map.getOrDefault(2, 0)+1);
            }
            if(third[i % third.length] == answers[i]){
                map.put(3, map.getOrDefault(3,0)+1);
            }
        }
        int max = Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
