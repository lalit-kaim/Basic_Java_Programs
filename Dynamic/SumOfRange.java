import java.util.*;

class SumOfRange{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int sum[] = new int[n];
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        sum[0] = arr[0];
        for(int i=1;i<n;i++)
            sum[i] = sum[i-1]+arr[i];
        for(int i=0;i<t;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int ans = 0;
            if(x==0)
                ans = sum[y];
            else
                ans = sum[y]-sum[x-1];
            System.out.println("Sum from "+x+" to "+y+" is : "+ans);
        }
    }
}