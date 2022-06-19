package morechilly;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /*
     * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다.
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 2개의 음식
     * 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
     *
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두번째로 맵지 않은 음식의 스코빌 지수 * 3)
     * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때 까지 반복하여 섞습니다.
     * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K 가 주어질 때,
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return하는 솔루션 만들기
     *
     * 단, 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1 을 리턴합니다.
     */

    public int solution(int[] scoville, int K){
        //
        int cnt = 0; //횟수
        Arrays.sort(scoville);
        while(scoville[0] < K){

        }
        return cnt;
    }

    public int getScovilleIdx(int first, int second){
        return first + (second * 3);
    }

    public static void main(String[] args){
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(new Solution().solution(scoville, K));
    }
}
