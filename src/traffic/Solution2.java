package traffic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Solution2 {
    public int solution(String[] lines) {
        int answer = 0;
        LocalDateTime[] starts = new LocalDateTime[lines.length];
        LocalDateTime[] ends = new LocalDateTime[lines.length];
        LocalDateTime[] duration = new LocalDateTime[lines.length * 2];
        int durationIdx = 0;
        for(int i = 0; i<lines.length; i++){
            String[] logs = lines[i].split("\\s");
            String processingTime = logs[2].substring(0,logs[2].indexOf('s'));
            int idx = processingTime.indexOf('.');
            long processingNanoseconds = 0;
             if (idx < 0){
                processingNanoseconds = TimeUnit.MILLISECONDS.toNanos(Long.parseLong(processingTime) * 1000 -1);
            }else{
                int miliLength = processingTime.substring(idx+1).split("").length;
                 //1자리면 *100, 2자리면 *10 3자리면 * 1
                long miliVal = Long.parseLong(processingTime.substring(idx+1)) * (miliLength == 1 ? 100 : miliLength ==2 ? 10 : 1);
                processingNanoseconds = TimeUnit.MILLISECONDS.toNanos(Long.parseLong(processingTime.substring(0,idx)) * 1000 + (miliVal-1));
            }
            LocalDateTime completionTime = LocalDateTime.parse(logs[0]+" "+logs[1], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
            starts[i] = completionTime.minusNanos(processingNanoseconds);
            ends[i]   = completionTime;
            duration[durationIdx++] = starts[i];
            duration[durationIdx++] = ends[i];
        }
        for(int i=0;i<duration.length;i++){
            LocalDateTime from = duration[i];
            LocalDateTime to   = from.plusNanos(TimeUnit.MILLISECONDS.toNanos(999));
            int cnt = 0;
            //이 비교문은 안통하네....
            for(int j=0;j<starts.length;j++){
                  if (isBetween(starts[j], ends[j], from) || isBetween(starts[j], ends[j], to)) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    private boolean isBetween(LocalDateTime from, LocalDateTime to, LocalDateTime it){
        if ((it.isEqual(from)||it.isAfter(from)) && (it.isBefore(to)||it.isEqual(to))) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
