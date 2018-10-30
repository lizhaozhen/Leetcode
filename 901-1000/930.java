class Solution {
    public int numSubarraysWithSum(int[] a, int s) {
        int len = a.length;
        int left = 0;
        int right = 0;
        
        int ans = 0;
        int sum = 0;
        while(true){
            while(right < len && sum < s){
                sum += a[right++];
            }
            
            if(right == len && sum < s) break;
            if(left == len) break;
            
            int leftNum = 0;
            for(int i=left;i<len;i++){
                if(a[i]!=0) break;
                leftNum++;
            }
            
            int rightNum = 0;
            for(int i=right;i<len;i++){
                if(a[i] == 1) break;
                rightNum++;
            }
            
            if(s == 0){
                if(leftNum > 0){
                    ans += leftNum * (leftNum + 1) / 2;
                    left += leftNum;
                }
                else{
                    left++;
                }
            }
            else{
                ans += (leftNum + 1) * (rightNum + 1);
                left += leftNum + 1;
                sum--;
            }
        }
        
        return ans;
    }
}