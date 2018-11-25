class Solution {
    public int bagOfTokensScore(int[] tokens, int p) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length-1;
        int s = 0;
        int ans = 0;
        while(left<=right){
            if(p>=tokens[left]){
                s++;
                p-=tokens[left++];
                ans = Math.max(ans, s);
            }
            else if(s>0){
                s--;
                p+=tokens[right--];
            }
            else break;
        }
        return ans;
    }
}