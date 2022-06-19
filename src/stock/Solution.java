package stock;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int[] solutionByArray(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i<prices.length; i++){
            int time = 0;
            for(int j = i ; j<prices.length; j++){
                ++time;
                if (prices[i] > prices[j]) break;
            }
            answer[i] = time;
        }
        return answer;
    }
    public int[] solution(int[] prices) {//solutionByQueue

        int[] answer = new int[prices.length];
        Queue<Integer> priceQueue = Arrays.stream(prices).boxed().collect(Collectors.toCollection(LinkedList::new));
        int idx = 0;
        while(true){
            if (priceQueue.isEmpty()) break;
            int time = 0;
            int price = priceQueue.poll();
            Iterator<Integer> iter = priceQueue.iterator();
            while(iter.hasNext()){
                ++time;
                if (price > iter.next()) break;
            }
            answer[idx++]=time;
        }
        return answer;
    }
    public static void main(String[] args) {
//        int[] prices = {1,2,3,2,3};
        int[] prices = {1,3,3,2,3,2};//[5,2,1,2,1,0]
        System.out.println(Arrays.toString(new Solution().solution(prices)));
    }

}
