package mathpoor;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] answers) {//인자는 정답
        Map<Integer,Integer> scoreCard = new HashMap<>();
        Map<Integer,int[]> patterns = new HashMap<>();
        patterns.put(1, new int[] {1,2,3,4,5});
        patterns.put(2, new int[] {2,1,2,3,2,4,2,5});
        patterns.put(3, new int[] {3,3,1,1,2,2,4,4,5,5});

        for(int i = 1; i<=3 ; i++) {
            int score = 0;
            int[] pattern = patterns.get(i);
            for (int j = 0; j < answers.length; j++) {
                int dap = pattern[j % pattern.length];
                if (dap == answers[j]) {
                    scoreCard.put(i, score++);
                }
            }
        }
        System.out.println(scoreCard);

        int maxScore = scoreCard.values().stream().mapToInt(e->e).max().getAsInt();
        List<Map.Entry<Integer,Integer>> scoreEntry = new ArrayList(scoreCard.entrySet());
        Collections.sort(scoreEntry, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int t = o2.getValue() - o1.getValue();
                if (t == 0){
                    return o1.getKey() - o2.getKey();
                }else{
                    return t;
                }
            }
        });
        return scoreEntry.stream().filter(f->f.getValue() == maxScore).map(entry -> entry.getKey()).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] answer = {
                1,3,2,4,2,2
                //1,3,2,4,2
                //1,2,3,4,5
                //5,4,4,4,4
        };

        System.out.println(Arrays.toString(new Solution().solution(answer)));
    }
    /*old answer
    import java.util.*;
import java.util.stream.Collectors;

    class Solution {
        public int[] solution(int[] answers) {//인자는 정답
            int[] answer = new int[3];

            int[] a = {1, 2, 3, 4, 5};
            int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            for(int i = 0; i<answers.length; i++) {
                //1번
                int j = (i+1)%5 == 0 ? 4 : (i+1)%5 - 1;
                j = a[j];
                if (answers[i] == j) {
                    answer[0]++;
                }
                //2번
                int k = (i+1)%8 == 0 ? 7 : (i+1)%8 - 1;
                k = b[k];
                if (answers[i] == k) {
                    answer[1]++;
                }
                //3번
                int l = (i+1)%10 == 0 ? 9 : (i+1)%10 - 1;
                l = c[l];
                if (answers[i] == l) {
                    answer[2]++;
                }
            }

            //maxValue
            int[] copy = Arrays.copyOf(answer, 3);
            Arrays.sort(copy);
            int maxValue = copy[2];

            List<Integer> rankList = new ArrayList<>();

            for(int i=0; i<answer.length; i++) {
                if (answer[i] == maxValue) {
                    rankList.add(i+1);
                }
            }

            Integer[] rank = rankList.toArray(new Integer[rankList.size()]);
            int[] ret = new int[rankList.size()];

            for(int i=0; i<ret.length;i++) {
                ret[i] = rank[i];
            }

            Arrays.sort(ret);

            return ret;
        }

    }

     */

}
