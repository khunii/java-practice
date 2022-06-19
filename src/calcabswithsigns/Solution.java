package calcabswithsigns;

import java.util.Arrays;

public class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int[] withSigns = new int[absolutes.length];
        for(int i = 0; i<absolutes.length ; i++){
            withSigns[i] = signs[i] ? absolutes[i] : (-1) * absolutes[i];
        }

        return Arrays.stream(withSigns).sum();
    }

    public static void main(String[] args) {
        int[] asolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(new Solution().solution(asolutes, signs));
    }
}
