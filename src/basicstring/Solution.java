package basicstring;

public class Solution {
    public boolean solution(String s) {
        String regEx = "[0-9]+";
        if (s.length() == 4 || s.length() ==6){
            return s.matches(regEx);
        }
        return false;
    }
}
