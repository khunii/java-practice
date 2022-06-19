package sqrt;

public class Solution {
    public long solution(long n) {

        double a = Math.sqrt(n);
        long b = (long)a;
        if (a == b){
            return (long) Math.pow(b+1, 2);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println((long)(Math.sqrt(4)));
        System.out.println(Math.sqrt(4)==(long)(Math.sqrt(4)));
    }
}
