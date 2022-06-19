package convert;

import java.util.Arrays;

public class Solution {
    public int solution(String s) {
        char sign = s.charAt(0);
        if (sign == '-'){
            return Integer.parseInt(s.substring(1)) * (-1);
        }else if (sign == '+'){
            return Integer.parseInt(s.substring(1));
        }else{
            return Integer.parseInt(s);

        }
    }
}
