package three;

import java.util.Arrays;

public class Solution {
    public int solution(int n) {
        /*
         * n: 자연수
         * n을 3진법으로 연산
         * 연산한 수를 역으로 배치
         * 역배치된 수를 10진수로 바꿔서 리턴
         */
        String _3radix = Integer.toString(n, 3);
        System.out.println(_3radix);
        char[] _3radixChars = _3radix.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = _3radixChars.length-1; i>=0; i--){
            sb.append(_3radixChars[i]);
        }
        System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(), 3);
    }

    public static void main(String[] args) {
        Integer n = 45;

        System.out.println(new Solution().solution(n));
    }
}
