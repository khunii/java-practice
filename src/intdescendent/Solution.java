package intdescendent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {
    public long solution(long n) {
        return Long.parseLong(Arrays.stream((n+"").split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining()));
    }

    public static void main(String[] args) {
        long n = 118372;
        System.out.println(new Solution().solution(n));
    }
}
