package printer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> originIndex = new LinkedList<>();
        Queue<Integer> printerQueue = new LinkedList<>();
        Queue<Integer> finalOrder = new LinkedList<>();
        Queue<Integer> finalIndex = new LinkedList<>();
        for(int i:priorities){
            printerQueue.offer(i);
        }
        for(int i = 0; i<priorities.length ; i++){
            originIndex.offer(i);
        }

        System.out.println(printerQueue);
        System.out.println(originIndex);

        while(true){
            if (printerQueue.isEmpty()) break;
            int front = printerQueue.peek();
            if (printerQueue.stream().filter(e->e>front).count() > 0){
                //나머지에 큰게 있으면
                printerQueue.offer(printerQueue.poll());
                originIndex.offer(originIndex.poll());
            }else{
                finalOrder.offer(printerQueue.poll());
                finalIndex.offer(originIndex.poll());
            }
        }

        System.out.println(printerQueue);
        System.out.println(originIndex);
        System.out.println(finalOrder);
        System.out.println(finalIndex);


        int[] results = finalIndex.stream().mapToInt(i->i).toArray();
        for(int i=0; i<results.length; i++){
            if (results[i]==location){
                answer = i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {1,2,1,2,1,2};
        int location = 1;
        System.out.println(new Solution().solution(priorities, location));
    }
}
