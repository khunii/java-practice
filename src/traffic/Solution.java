package traffic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        LocalDateTime[] starts = new LocalDateTime[lines.length];
        LocalDateTime[] ends = new LocalDateTime[lines.length];
        LocalDateTime[] durations = new LocalDateTime[lines.length*2];//연습용
        int durationIdx = 0;
        for(int i = 0; i<lines.length; i++){
            String[] logs = lines[i].split("\\s");
            String processingTime = logs[2].substring(0,logs[2].indexOf('s'));
            int idx = processingTime.indexOf('.');
            long processingSeconds  = 0;
            long processingMilliseconds = 0;
            if (idx < 0){
                processingSeconds = Long.parseLong(processingTime);
            }else{
                processingSeconds = Long.parseLong(processingTime.substring(0, processingTime.indexOf('.')));
                String[] mili = processingTime.substring(processingTime.indexOf('.')+1).split("");
                for(int j = 0; j<mili.length; j++){
                    if (j==0) processingMilliseconds = Long.parseLong(mili[j]) * 100;
                    else if (j==1)
                        processingMilliseconds = processingMilliseconds + (Long.parseLong(mili[j])*10);
                    else
                        processingMilliseconds = processingMilliseconds + (Long.parseLong(mili[j]));
                }
            }
            long processingNanoseconds = TimeUnit.MILLISECONDS.toNanos(processingSeconds * 1000 + processingMilliseconds-1);
            LocalDateTime completionTime = LocalDateTime.parse(logs[0]+" "+logs[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
            starts[i] = completionTime.minusNanos(processingNanoseconds);
            ends[i]   = completionTime;

            //이 indexing 알고리즘...
            durations[durationIdx++] = completionTime.minusNanos(processingNanoseconds);
            durations[durationIdx++] = completionTime;
        }
        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));
        LocalDateTime unitTime = starts[0];
        while(!unitTime.isAfter(ends[ends.length-1]) && !unitTime.isEqual(ends[ends.length-1])){
            LocalDateTime unitEndTime = unitTime.plusNanos(TimeUnit.MILLISECONDS.toNanos(999));
            int cnt = 0;
            for(int i = 0; i< starts.length;i++){
                //1. 구간 이전 또는 구간에서 시작해서 구간에서 끝난 건
                //2. 구간 이전 또는 구간에서 시작해서 구간에서 아직 안끝난 건
                if (
                        ((ends[i].isEqual(unitEndTime)||((ends[i].isEqual(unitTime)||ends[i].isAfter(unitTime))&&ends[i].isBefore(unitEndTime)))) ||
                                ((starts[i].isBefore(unitEndTime)||starts[i].isEqual(unitEndTime))&&ends[i].isAfter(unitEndTime))
                ){
                    cnt++;
                }
            }
//            System.out.println("x축 비교시간 : " + unitTime + "~" + unitTime.plusNanos(TimeUnit.MILLISECONDS.toNanos(999)) + ", 처리개수 : " + cnt);
            answer = Math.max(answer, cnt);
            unitTime = unitTime.plusNanos(TimeUnit.MILLISECONDS.toNanos(1)); //0.001초씩 구간 증가(x축)
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
//        String[] lines ={
//                "2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"
//        };
        System.out.println(s.solution(lines));
    }
}
