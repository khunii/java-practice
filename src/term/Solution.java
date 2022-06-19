package term;

import java.util.Arrays;

public class Solution {
    public long[] solution(int input, int n) {
        long x = input;


        long[] answer = new long[n];
        for(int i = 1; i <= n; i++ ){
            answer[i-1] = x * i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int input = -4;
        int n = 2;
        System.out.println(Arrays.toString(new Solution().solution(input, n)));
    }
}
