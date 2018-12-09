class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        
        int sum = 0;
        for(int rod: rods){
            sum += rod;
        }
        
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] rs = new int[1<<n];
        for(int i=0;i<n;i++) rs[1<<i] = rods[i];
        for(int i=1;i<(1<<n);i++){
            if(rs[i] == 0){
                int l = i & (-i);
                rs[i] = rs[i^l] + rs[l];
            }
            
            int num = rs[i];
            if(num > sum/2) continue;
            if(!hm.containsKey(num)){
                hm.put(num, new ArrayList<Integer>());
            }
            hm.get(num).add(i);
        }
        
        for(int i=sum/2;i>0;i--){
            if(!hm.containsKey(i)) continue;
            List<Integer> arr = hm.get(i);
            for(int j=0;j<arr.size();j++){
                for(int k=j+1;k<arr.size();k++){
                    if((arr.get(j)&arr.get(k))==0){
                        return i;
                    }
                }
            }
        }
        
        return 0;
    }
}