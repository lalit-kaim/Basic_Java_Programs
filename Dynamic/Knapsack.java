public class Knapsack {
    public static void main(String[] args) {
        int w[] = {2,5,4,8,6,3,1};
        int v[] = {8,5,7,1,5,9,6};
        int n = w.length;
        int W = 10;
        int mat[][] = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            mat[i][0] = 0;
            mat[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(w[i-1]<j)
                    mat[i][j] = Math.max(v[i-1]+mat[i-1][j-w[i-1]], mat[i-1][j]);
                else    
                    mat[i][j] = mat[i-1][j];
            }
        }
        System.out.println("Max profit gain : "+mat[n][W]);
    }
}
