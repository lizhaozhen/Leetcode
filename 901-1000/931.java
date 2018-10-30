class Solution {
    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        
        int[] cur = new int[n];
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                cur[j] = A[i][j];
            }
            for(int j=0;j<n;j++){
                int num = A[i-1][j];
                if(j>0) num = Math.min(num, A[i-1][j-1]);
                if(j<n-1) num = Math.min(num, A[i-1][j+1]);
                A[i][j] = num + cur[j];
            }
        }
        
        int ans = A[m-1][0];
        for(int i=1;i<n;i++) ans = Math.min(ans, A[m-1][i]);
        return ans;
    }
}