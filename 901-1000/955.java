class Solution {
    boolean meet(String[] a, boolean[] ds, int start, int end, int p, int ep){
        if(p == ep) return true;
        if(ds[p]) return meet(a, ds, start, end, p + 1, ep);
        if(start == end-1) return true;
        
        for(int i=start;i<end-1;i++){
            if(a[i].charAt(p) > a[i+1].charAt(p)) return false;
        }
        
        for(int i=start;i<end-1;){
            int j=i+1;
            while(j< end && a[i].charAt(p) == a[j].charAt(p)) j++;
            if(!meet(a, ds, i, j, p + 1, ep)) return false;
            i=j;
        }
        return true;
    }
    
    public int minDeletionSize(String[] A) {
        if(A.length <= 1) return 0;
        
        int m = A.length;
        int n = A[0].length();
        boolean[] ds = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!meet(A, ds, 0, m, 0, i+1)){
                ds[i] = true;
            }
            else if(meet(A, ds, 0, m, 0, n)){
                break;
            }
        }
        
        int ans = 0;
        for(boolean d: ds){
            if(d) ans++;
        }
        return ans;
    }
}