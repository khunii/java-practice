package strange;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        String answer = "";
        String[] elements = s.split("\\s",-1);
        System.out.println(Arrays.toString(elements));
        for(int e=0; e<elements.length; e++){
            for(int i = 0; i<elements[e].length();i++){
                if (i%2 == 0){
                    answer += Character.toUpperCase(elements[e].charAt(i));
                }else{
                    answer += Character.toLowerCase(elements[e].charAt(i));
                }
            }
            if (e != elements.length-1) answer += " ";
        }
        return answer;

    }

    public static void main(String[] args) {
        String s = "try  hello   world";
        System.out.println(new Solution().solution(s));

//        String test = "1:2:3::::";
//        String[] testSplit = test.split(":",5);
//        System.out.println(Arrays.toString(testSplit));
//        for(String dd : testSplit){
//            System.out.println(dd.length());
//        }
    }
}
