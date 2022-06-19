package toarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(long n) {
        List<Integer> reverse = new ArrayList<>();
        do{
            int temp = (int)n;
            System.out.println("temp: " + temp);
            int a = temp%10;
            int b = (int)(n%10);
            System.out.println(a + ":" +b);
            reverse.add((int)(n%10));
            n = n/10;
        }while(n>0);
        return reverse.stream().mapToInt(i->i).toArray();
//         List<Integer> l = new ArrayList<>();
//         while(true){
//             l.add((int)(n%10));
//             if (n < 10) break;
//             n = n/10;
//         }
//         int[] answer = new int[l.size()];
//         for(int i=0;i<answer.length;i++){
//             answer[i] = l.get(i);
//         }
//         return answer;


    }

    public static void main(String[] args) {
        long n = 100000000000L;
        System.out.println(Arrays.toString(new Solution().solution(n)));
    }
}
