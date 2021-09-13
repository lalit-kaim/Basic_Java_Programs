import java.util.*;

class LIS{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lis[] = new int[n];
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            lis[i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && lis[i]<lis[j]+1)
                    lis[i] = lis[j] + 1;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(ans, lis[i]);
        System.out.println("Longest Increasing subsequence : "+ans);
    }
}