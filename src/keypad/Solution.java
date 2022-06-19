package keypad;

public class Solution {

    public String solution(int[] numbers, String hand) {
        /*
             1 2 3
             4 5 6
             7 8 9
             * 0 #

             00 01 02
             10 11 12
             20 21 22
             30 31 32
         */
        String answer = "";
        int currL = 0;
        int currR = 0;
        for(int i = 0; i<numbers.length; i++){
           if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
               answer += "L";
               currL = numbers[i];
           }else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
               answer += "R";
               currR = numbers[i];
           }else{
               //거리계산?
               int LDistance = getDistance(currL, numbers[i]);
               int RDistance = getDistance(currR, numbers[i]);
               if (LDistance == RDistance){
                   if (hand.equals("right")){
                       answer += "R";
                       currR = numbers[i];
                   }else{
                       answer += "L";
                       currL = numbers[i];
                   }
               }else if(LDistance < RDistance){
                   answer += "L";
                   currL = numbers[i];
               }else if(RDistance < LDistance){
                   answer += "R";
                   currR = numbers[i];
               }
           }

        }
        return answer;
    }

    public int getDistance(int curr, int n){
        int[][] keypad = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-2}
        };
        int currX = 0;
        int currY = 0;
        int nX = 0;
        int nY = 0;

        for(int i = 0; i<keypad.length; i++){
            for(int j = 0; j<keypad[i].length; j++){
                if (n == keypad[i][j]){
                    nX = i;
                    nY = j;
                }
            }
        }
        for(int i = 0; i<keypad.length; i++){
            for(int j = 0; j<keypad[i].length; j++){
                if (curr == keypad[i][j]){
                    currX = i;
                    currY = j;
                }
            }
        }

        return (Math.abs(nX-currX)) + (Math.abs(nY-currY));
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(new Solution().solution(numbers, hand));
    }
}
