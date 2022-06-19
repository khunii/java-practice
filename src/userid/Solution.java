package userid;

public class Solution {
    /*
    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     */
    public String solution(String new_id) {
        String id = new_id;
        id = id.toLowerCase();
        System.out.println(id);
        id = id.replaceAll("[^a-z0-9\\-_\\.]","");
        System.out.println(id);
        id = id.replaceAll("[\\.]{2,}",".");
        System.out.println(id);
        id = id.startsWith(".") ? id.substring(1) : id;
        System.out.println(id);
        id = id.endsWith(".") ? id.substring(0, id.length()-1) : id;
        System.out.println(id);
        id = id.isEmpty() ? "a" : id;
        System.out.println(id);
        id = id.length() >= 16 ? id.substring(0,15) : id;
        System.out.println(id);
        id = id.endsWith(".") ? id.substring(0, id.length()-1) : id;
        System.out.println(id);
        if (id.length() <= 2){
            char lastChar = id.charAt(id.length()-1);
            while(id.length()<3){
                id = id + lastChar;
            }
        }
        System.out.println(id);
        return id;

        /*
                String temp_new_id = new_id.toLowerCase();
        String rule2_regEx="[^a-z0-9\\-_\\.]";
        temp_new_id = temp_new_id.replaceAll(rule2_regEx,"");
        String rule3_regEx="[\\.]{2,}";
        temp_new_id = temp_new_id.replaceAll(rule3_regEx,".");
        if (".".equals(temp_new_id.substring(0,1))){
            temp_new_id = temp_new_id.substring(1);
        }
        if (temp_new_id.isEmpty()){
            temp_new_id = "a";
        }
        if (temp_new_id.length()>=16){
            temp_new_id = temp_new_id.substring(0,15);
        }
        if (".".equals(temp_new_id.substring(temp_new_id.length()-1))){
            temp_new_id = temp_new_id.substring(0,temp_new_id.length()-1);
        }

        if (temp_new_id.length()<=2){
            String lastChar = temp_new_id.substring(temp_new_id.length()-1);
            while(temp_new_id.length()<3){
                temp_new_id+=lastChar;
            }
        }

        return temp_new_id;


         */
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("입력 : " + new_id);
        System.out.println(new Solution().solution(new_id));
    }
}
