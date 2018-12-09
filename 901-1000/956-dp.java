
/* 
dp[i] = j max sum when difference is i
*/

class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        
        int sum = 0;
        for(int rod: rods) sum += rod;
        
        int[] dp = new int[sum+1];
        for(int i=1;i<=sum;i++) dp[i] = -sum;
        
        for(int i=0;i<n;i++){
            int num = rods[i];
            int[] next = dp.clone();
            for(int j=0;j<=sum;j++){
                if(dp[j] >= 0){
                    next[Math.abs(j-num)] = Math.max(next[Math.abs(j-num)], dp[j] + Math.max(j, num) - Math.abs(j-num));
                    next[j+num] = Math.max(next[j+num], dp[j]);
                }
            }
            dp = next;
        }
        
        return dp[0];
    }
}