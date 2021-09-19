public class Subsetsum {
    static boolean subsetsum(int a[], int sum, int n){
        if(sum==0)
            return true;
        if(n==0)
            return false;
        else
            return subsetsum(a, sum-a[n-1], n-1) || subsetsum(a, sum, n-1);
    }
    public static void main(String[] args) {
        int a[] = {1,5,4,8,6,26,12};
        int n = a.length;
        int sum = 465;
        System.out.println(subsetsum(a, sum, n));
    }
}
