import java.util.*;

class ClimbingStairs_2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fee[] = new int[n];
        int min_fee[] = new int[n+1];
        for(int i=0;i<n;i++)
            fee[i] = sc.nextInt();
        min_fee[0] = 0;
        min_fee[1] = fee[0];
        min_fee[2] = fee[0];
        for(int i=3;i<=n;i++)
            min_fee[i] = Math.min(Math.min(min_fee[i-1]+fee[i-1], min_fee[i-2]+fee[i-2]), min_fee[i-3]+fee[i-3]);
        System.out.println("Minimum fee to pay to reach nth stair : "+min_fee[n]);
    }
}