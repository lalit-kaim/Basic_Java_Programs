public class Knapsack {
    static int knapsack(int w[], int v[], int W, int n){
        if(n==0 || W==0)
            return 0;
        if(w[n-1]<=W)
            return Math.max(v[n-1]+ knapsack(w, v, W-w[n-1], n-1), knapsack(w, v, W, n-1));
        else
            return knapsack(w, v, W, n-1);
    }
    public static void main(String[] args) {
        int w[] = {2,5,4,8,6,3,1};
        int v[] = {8,5,7,1,5,9,6};
        int W = 10;
        System.out.println("Max Profit gained : "+knapsack(w, v, W, w.length));
    }
}
