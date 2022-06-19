package picktwoforplus;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> plusSet = new TreeSet<>();
        for(int i = 0; i<numbers.length ; i++){
            for(int j = i+1; j<numbers.length; j++){
                plusSet.add(numbers[i]+numbers[j]);
            }
        }
        return plusSet.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        System.out.println(Arrays.toString(new Solution().solution(numbers)));
    }
}
