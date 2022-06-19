package sumbetweentwo;

public class Solution {
    public long solution(int a, int b) {
        if (a == b) return a;
        int start = a>b?b:a;
        int end = a>b?a:b;
        long sum = 0L;
        for(int i = start ; i<=end; i++){
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = -2;
        System.out.println(new Solution().solution(a, b));
    }
}
