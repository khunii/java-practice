package secretmap;

import java.util.Arrays;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i<n ; i++){
            String _row1 = Integer.toString(arr1[i], 2);
            String _row2 = Integer.toString(arr2[i], 2);
            while(_row1.length() < n){
                _row1 = "0" + _row1;
            }
            while(_row2.length() < n){
                _row2 = "0" + _row2;
            }
            String temp = "";
            for(int j = 0; j < n; j++){
                if (_row1.charAt(j) == '1' || _row2.charAt(j) == '1'){
                    temp+="#";
                }else{
                    temp+=" ";
                }
            }
            answer[i] = temp;
            //System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})));
    }
}
