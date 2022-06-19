package maxnum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) return -1;
                if (Integer.valueOf(o1.toString()+o2.toString()) > Integer.valueOf(o2.toString() + o1.toString())){
                    return -1;
                }else {
                    return 1;
                }
            }
        }).map(String::valueOf).collect(Collectors.joining());
        return answer.startsWith("0") ? "0" : answer;
//        return Arrays.stream(numbers).mapToObj(String::valueOf)
//                .sorted(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        if (o1.equals(o2)) return 1;
//                        if (Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1)){
//                            return -1;
//                        }else{
//                            return 1;
//                        }
//                    }
//                }).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        int[] numbers = {0,0,0,1,0};//1000, 0, 5, 99, 100
        //3, 30, 34, 5, 9
//        int[] numbers = {1000};
        System.out.println(new Solution().solution(numbers));
//        for(int i = 0; i<=1000; i++){
//            String s = String.valueOf(i);
//            System.out.println(Integer.parseInt("0"+s));
//            System.out.println(Integer.parseInt(s+"0"));
//        }
//        IntStream.rangeClosed(0,1000).mapToObj(String::valueOf)
//        System.out.println(Integer.parseInt("1000"+"1000"));
//        Arrays.stream(numbers).mapToObj(String::valueOf)
//                .sorted(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        if(Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1)){
//                            return -1;
//                        }else{
//                            return 1;
//                        }
//                    }
//                }).forEach(System.out::println);
    }
}
