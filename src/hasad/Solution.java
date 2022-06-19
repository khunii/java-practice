package hasad;

import java.util.Arrays;

public class Solution {
    public boolean solution(int x) {
        int sum = Arrays.stream((x+"").split("")).map(Integer::parseInt).mapToInt(i->i).sum();
        int mok = x%sum;
        if (mok == 0) return true;
        return false;
    }
}
