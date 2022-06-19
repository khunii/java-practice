package uniform;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // n : 전체 학생수
        // lost : 체육복 분실자 목록
        // reserve : 체육복 여벌 있는 사람 목록
        // 반환 : 최대로 체육수업에 참여할 수 있는 학생수

        /*
        n	lost	reserve	return
        5	[2, 4]	[1, 3, 5]	5
        5	[2, 4]	[3]	4
        3	[3]	[1]	2
         */
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = 1;
        }
        for (int l : lost) {
            cnt[l - 1] = 0; //lost
        }
        for(int r : reserve){
            cnt[r-1]++;//reserve값 반영
        }
        for(int i = 0; i<n ; i++){
            if (cnt[i] == 0){//lost면...
                //앞탐색
                if (i == 0){
                    //맨앞이면 다음만 탐색가능
                    if (cnt[i+1] > 1){
                        cnt[i]++;
                        cnt[i+1]--;
                        continue;
                    }
                }else if(i == n-1){
                    //맨뒤면 이전만 탐색가능
                    if (cnt[i-1] > 1){
                        cnt[i]++;
                        cnt[i-1]--;
                        continue;
                    }
                }else{
                    //앞뒤 다 탐색필요
                    if (cnt[i-1] > 1){
                        cnt[i]++;
                        cnt[i-1]--;
                        continue;
                    }
                    if (cnt[i+1] > 1){
                        cnt[i]++;
                        cnt[i+1]--;
                        continue;
                    }
                }

            }
        }
        return (int) Arrays.stream(cnt).filter(f->f>=1).count();
    }

    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(new Solution().solution(n, lost, reserve));
    }
}
