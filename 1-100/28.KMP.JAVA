class Solution {
    public int[] getNext(String s){
        int[] next = new int[s.length()];
        int len = 0;
        for(int i=1;i<s.length();){
            if(s.charAt(len) == s.charAt(i)){
                next[i++] = ++len;
            }
            else if(len > 0){
                len = next[len-1];
            }
            else i++;
        }
        return next;
    }
    
    public int strStr(String s, String needle) {
        int[] next = getNext(needle);
        if(next.length == 0) return 0;
        
        int len = 0;
        for(int i=0;i<s.length();){
            if(s.charAt(i) == needle.charAt(len)){
                i++;
                len++;
                if(len == next.length) return i-len;
            }
            else if(len > 0){
                len = next[len-1];
            }
            else i++;
        }
        
        return -1;
    }
}