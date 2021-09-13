import java.util.*;

class NightOut{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextInt();
        int ans[] = new int[n];
        ans[0] = a[0];
        ans[1] = Math.max(a[0], a[1]);
        for(int i=2;i<n;i++){
            ans[i] = Math.max(a[i]+ans[i-2], ans[i-1]);
        }
        System.out.println("Max amount can be rob : "+ans[n-1]);
    }
}