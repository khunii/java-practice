package accuse;

import java.util.*;

public class Solution {public int[] solution(String[] id_list, String[] report, int k) {
    int id_list_size = id_list.length;
    int report_size = report.length;
    int[] answer = new int[id_list_size];


    Map<String, String> reportMap = new HashMap<>();
    for (int i = 0; i < report_size; i++) {
        String[] pair = report[i].split("\\s");
        if (pair[0].equals(pair[1])) continue;
        if (!reportMap.containsKey(pair[1])) {
            reportMap.put(pair[1], pair[0]);
        } else {
            boolean isOK = true;
            for (String singoja : reportMap.get(pair[1]).split(",")) {
                if (singoja.equals(pair[0])) {
                    isOK = false;
                    break;
                }
            }
            if (isOK) {
                reportMap.put(pair[1], reportMap.get(pair[1]) + "," + pair[0]);
            }
        }
    }
    //frodo:muzi,apeach
    //neo:frodo,muzi
    //muzi:apeach
    List<String> mailTargetId = new ArrayList<>();
    for (Map.Entry<String, String> entry : reportMap.entrySet()) {
        String[] ids = entry.getValue().split(",");
        if (ids.length >= k) {
            for (String id : ids) {
                mailTargetId.add(id);
            }
        }
    }

    //["muzi", "frodo", "apeach", "neo"]
    for (int i = 0; i < id_list.length; i++) {
        for (String targetId : mailTargetId) {
            if (id_list[i].equals(targetId)) {
                answer[i]++;
            }
        }
    }
    return answer;
}
}
