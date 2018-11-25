class Solution {
    public int minIncrementForUnique(int[] a) {
        Arrays.sort(a);
        if(a.length <= 1) return 0;
        
        int ans = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int num:a) hs.add(num);
        
        int next = a[0];
        for(int i=0;i<a.length-1;i++){
            if(a[i] == a[i+1]){
                if(next < a[i]) next = a[i];
                while(hs.contains(next)) next++;
                ans+=next-a[i];
                hs.add(next);
            }
        }
        return ans;
    }
}