import java.util.*;

class RodCutting{
    public static int rod(int cost[], int n){
        if(n==0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, cost[i]+rod(cost, n-i-1));
        }
        return max;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cost[] = new int[n];
        for(int i=0;i<n;i++)
            cost[i] = sc.nextInt();
        System.out.println("Max profit on rod cutting : "+rod(cost, n));
    }
}