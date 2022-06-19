package picture;

import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        List<Area> areaList = new ArrayList<>();

        /*
         * 1 <= m, n <= 100
         * picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
         * picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
         * 0은 제외(빈칸이므로)
         */
        for(int i = 0; i<m ; i++) {
            for(int j = 0; j<n; j++) {
                if (picture[i][j] == 0) continue;
                //현재 좌표를 주면, 상/하/좌/우 비교해서 값이 같으면 값이 같은 좌표배열 list를 반환
                //같은게 없으면 반환list count == 0;
                List<Integer[]> members = getMemebersOfArea(i, j, picture);
                if (members.size() > 0) {
                    boolean isNew = true;
                    for(Area area : areaList) {
                        if (area.amImember(new int[] {i,j})) {
                            area.addMemberList(members);
                            isNew = false;
                        }
                    }
                    if (isNew) {
                        Area newArea = new Area(picture[i][j]);
                        newArea.addMemberList(members);
                        //newArea.addMember(new int[] {i,j});//자기 자신도 member여야지...
                        areaList.add(newArea);
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = areaList.size();
        for(Area area:areaList) {
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area.count());
        }
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private List<Integer[]> getMemebersOfArea(int i, int j, int[][] picture) {

        List<Integer[]> members = new ArrayList<>();
        int color = picture[i][j];
        members.add(new Integer[] {i, j}); //자신은 default
        if (i>0) if (picture[i-1][j] == color) members.add(new Integer[] {i-1, j});//상
        if (i<picture.length-1) if (picture[i+1][j] == color) members.add(new Integer[] {i+1, j});//하
        if (j>0) if (picture[i][j-1] == color) members.add(new Integer[] {i, j-1});//좌
        if (j<picture[i].length-1) if (picture[i][j+1] == color) members.add(new Integer[] {i, j+1});//우
        return members;
    }

    class Area {
        int color;
        List<Integer[]> members = new ArrayList<>();
        public Area(int color){
            this.color = color;
        }
        public boolean amImember(int[] position) {
            for(Integer[] e:members) {
                if (position[0]==e[0] && position[1]==e[1]) return true;
            }
            return false;
        }
        private void addMember(int[] position) {
            members.add(Arrays.stream(position).boxed().toArray(Integer[]::new));
        }
        public void addMemberList(List<Integer[]> positions) {
            for(Integer[] position:positions) {
                if (!amImember(new int[] {position[0].intValue(), position[1].intValue()})) {
                    addMember(new int[] {position[0].intValue(), position[1].intValue()});
                }
            }
        }
        public int count() {
            return members.size();
        }
    }
}