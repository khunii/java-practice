package numarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if (arr[i]%divisor == 0){
                answer.add(arr[i]);
            }
        }
        if (answer.isEmpty()) answer.add(-1);
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
}
