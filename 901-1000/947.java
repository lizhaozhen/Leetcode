class Solution {
    int[] root;
    int[] num;
    
    int getRoot(int x){
        if(x == root[x]) return x;
        return root[x] = getRoot(root[x]);
    }
    
    void union(int x, int y){
        x = getRoot(x);
        y = getRoot(y);
        if(x == y) return;
        
        if(num[x] > num[y]){
            num[x] += num[y];
            root[y] = x;
        }
        else{
            num[y] += num[x];
            root[x] = y;
        }
    }
    
    public int removeStones(int[][] stones) {
        int n = stones.length;
        root = new int[n];
        num = new int[n];
        for(int i=0;i<n;i++) root[i] = i;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i,j);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) if(i == getRoot(i)) ans++;
        return n-ans;
    }
}