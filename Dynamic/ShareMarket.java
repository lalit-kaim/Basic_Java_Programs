import java.util.*;

class ShareMarket{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int price[] = new int[n];
        for(int i=0;i<n;i++)
            price[i] = sc.nextInt();
        int a[] = new int[n];
        a[0] = price[0];
        for(int i=1;i<n;i++)
            a[i] = Math.min(a[i-1], price[i]);
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            maxProfit = Math.max(maxProfit, price[i]-a[i]);
        System.out.println("Max profit on buying and selling a share is : "+maxProfit);
    }
}