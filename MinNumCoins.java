import java.util.*;
class MinNumCoins{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = {1,2,5,10,20,50,100,200,500,2000};
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int i=9;i>=0;i--){
            while(n-a[i]>=0){
                n -= a[i];
                ls.add(a[i]);
            }            
        }
        for(int x : ls)
            System.out.println(x+" ");
    }
}