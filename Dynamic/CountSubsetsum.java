public class CountSubsetsum {
    public static void main(String[] args) {
        int arr[] = {3,2,2,3};
        int n = arr.length;
        int sum = 5;
        int a[][] = new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
            a[i][0] = 1;
        for(int i=1;i<=sum;i++)
            a[0][i] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j)
                    a[i][j] = a[i-1][j-arr[i-1]] + a[i-1][j];
                else
                    a[i][j] = a[i-1][j];
            }
        }
        System.out.println(a[n][sum]);
    }
}
