import java.util.*;
class LCS{
    public static int rec(String a, String b){
        if(a.length()==0 || b.length()==0)
            return 0;
        if(a.charAt(0)==b.charAt(0))
            return 1+rec(a.substring(1), b.substring(1));
        else    
            return Math.max(rec(a, b.substring(1)), rec(a.substring(1), b));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(rec(a, b));
    }
}