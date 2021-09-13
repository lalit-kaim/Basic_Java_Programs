import java.util.*;

class OnTheWayToHome{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[][] = new int[m][n];
        for(int i=0;i<m;i++)
            a[i][0] = 1;
        for(int i=0;i<n;i++)
            a[0][i] = 1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                a[i][j] = a[i-1][j] + a[i][j-1];
        System.out.println("No. of ways to reach from top left to right left : "+a[m-1][n-1]);
    }
}