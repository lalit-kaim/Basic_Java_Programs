import java.util.*;
class LCS{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int m = a.length();
        int n = b.length();
        int arr[][] = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                    arr[i][j] = arr[i-1][j-1]+1;
                else    
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
            }
        }
        System.out.println(arr[m][n]);
    }
}