public class LQSubString{
    public static void main(String[] args) {
        String str = "abcabcbb";
        int n = str.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[256];
            for(int j = i; j < n; j++){
                if (visited[str.charAt(j)] == true)
                    break;
                else{
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
        }
        System.out.println("Longest Unique SubString length is : "+res);
    }
}