import java.util.*;

class ClimbingStairs{
    public static int rec(int n){
        if(n==1 || n==0)
            return 1;
        return rec(n-1)+rec(n-2);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("No. of ways to reach nth stair : "+rec(n));
    }
}
