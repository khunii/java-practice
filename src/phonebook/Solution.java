package phonebook;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> numSet = (HashSet<String>)Arrays.stream(phone_book).collect(Collectors.toSet());
        for(String element:numSet){
            for(int i = 1; i <= element.length()-1; i++){//자기자신과 같은 key는 제외하기 위함
                if(numSet.contains(element.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean firstsolution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i< phone_book.length; i++){
            if (i == phone_book.length-1) break;
            if (phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }

        }
        return true;

    }
    public boolean solution_fail(String[] phone_book) {
        boolean answer = true;
        for(int i = 0; i< phone_book.length; i++){
            for(int j = 0; j<phone_book.length; j++){
                if (i == j) continue;
                if (phone_book[j].startsWith(phone_book[i])){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;


    }

    public static void main(String[] args) {
        String s= "abcdefg";
        for(int i = 1; i<=s.length()-1 ; i++){
            System.out.println(s.substring(0,i));
        }
    }
}
