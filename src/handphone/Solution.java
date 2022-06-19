package handphone;

public class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i<phone_number.length()-4; i++){
            answer += "*";
        }
        return answer + phone_number.substring(phone_number.length()-4,phone_number.length());
    }

    public static void main(String[] args) {
        String phone_number = "8787";
        System.out.println(new Solution().solution(phone_number));
    }

}
