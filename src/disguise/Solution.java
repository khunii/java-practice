package disguise;

import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        /*
        {
          {kind, type},...
        }
         */
        Map<String, Integer> clothesMap = new HashMap<>();
        for(int i = 0; i<clothes.length;i++){
               if (clothesMap.containsKey(clothes[i][1])){
                   int cnt = clothesMap.get(clothes[i][1]);
                   clothesMap.put(clothes[i][1], ++cnt);
               }else{
                   clothesMap.put(clothes[i][1], 1);
               }
        }

        System.out.println(clothesMap);

        /*
        value총합 + key순환하면서 value곱합을 구하면 됨
         */
        int valueSum = 0;
        int valueMSum = 1;
        for(String key:clothesMap.keySet()){
            valueMSum *= clothesMap.get(key);
        }
//        for(Map.Entry<String,Integer> entry:clothesMap.entrySet()){
//            valueSum += entry.getValue();
//            if (clothesMap.keySet().size() > 1) {
//                valueMSum *= entry.getValue();
//            }else{
//                valueMSum = 0;
//            }
//        }

        return valueSum + valueMSum;
    }

    public static void main(String[] args) {
        /*
        [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
        [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]
         */
        String[][] clothes ={
                {"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        System.out.println(new Solution().solution(clothes));

    }
}
