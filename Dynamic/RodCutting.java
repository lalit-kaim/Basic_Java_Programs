import java.util.*;

class RodCutting{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cost[] = new int[n+1];
        for(int i=1;i<=n;i++)
            cost[i] = sc.nextInt();
        cost[0] = 0;
        int rod[] = new int[n+1];
        rod[0] = 0;
        for(int i=1;i<=n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<=i;j++)
                max = (int)Math.max(max, cost[j]+rod[i-j]);
            rod[i] = max;
        }
        System.out.println("Max profit on rod cutting : "+rod[n]);
    }
}