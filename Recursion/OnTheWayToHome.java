import java.util.*;

class OnTheWayToHome{
    public static int rec(int m, int n){
        if(m==1 || n==1)
            return 1;
        return rec(m-1, n) + rec(m, n-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        System.out.println("No. of ways to reach from top left to right left : "+rec(m, n));
    }
}