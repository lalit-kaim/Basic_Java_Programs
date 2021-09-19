public class Subsetsum {
    public static void main(String[] args) {
        int arr[] = {1,5,4,8,6,9,2};
        int n = arr.length;
        int sum = 20;
        boolean a[][] = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            a[i][0] = true;
        for(int i=1;i<=sum;i++)
            a[0][i] = false;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j)
                    a[i][j] = a[i-1][j-arr[i-1]] || a[i-1][j];
                else
                    a[i][j] = a[i-1][j];
            }
        }
        System.out.println(a[n][sum]);
    }
}
